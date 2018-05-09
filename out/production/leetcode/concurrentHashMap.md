
### ConcurrentHashMap JDK 1.8 源码学习


主要学习以下几个重点方法
1. putVal()
2. get()
3. size()
4. remove()

```

    final V putVal(K key, V value, boolean onlyIfAbsent) {
        if (key == null || value == null) throw new NullPointerException();
        int hash = spread(key.hashCode());
        // 获取桶的hash值
        int binCount = 0;
        for (Node<K,V>[] tab = table;;) {
        // 自旋插入
            Node<K,V> f; int n, i, fh;
            if (tab == null || (n = tab.length) == 0)
                tab = initTable();
                // 当前HashMap的TAB为空的时候做初始化操作  自旋
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
            // 当前Hash对应的Hash桶为空的时候 cas添加
                if (casTabAt(tab, i, null,
                             new Node<K,V>(hash, key, value, null)))
                    break;                   // no lock when adding to empty bin
            }
            else if ((fh = f.hash) == MOVED)
                // 当前桶在扩容时候 帮助扩容
                tab = helpTransfer(tab, f);
            else {
            // 插入
                V oldVal = null;
                // 加锁 对应每一个桶
                synchronized (f) {
                // 避免多线程 加锁
                    if (tabAt(tab, i) == f) {
                    //  fh = f.hash  标志为 -1 = MOVED   -2 = TreeBin 
                        if (fh >= 0) {
                            binCount = 1;
                            // 检查是否存在 不存在就插入 否则就修改
                            for (Node<K,V> e = f;; ++binCount) {
                                K ek;
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K,V>(hash, key,
                                                              value, null);
                                    break;
                                }
                            }
                        }
                        // 采用红黑树解决Hash冲突
                        else if (f instanceof TreeBin) {
                            Node<K,V> p;
                            binCount = 2;
                            // 红黑树插入
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                           value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                    }
                }
                if (binCount != 0) {
                // 大于8就采用红黑树解决Hash冲突
                    if (binCount >= TREEIFY_THRESHOLD)
                        treeifyBin(tab, i);
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        addCount(1L, binCount);
        return null;
    }
    
    public V get(Object key) {
        Node<K,V>[] tab; Node<K,V> e, p; int n, eh; K ek;
        // hash的再散列
        int h = spread(key.hashCode());
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (e = tabAt(tab, (n - 1) & h)) != null) {
            // hash值对应的桶不能为空
            if ((eh = e.hash) == h) {
           // 如果是首节点的话直接返回
                if ((ek = e.key) == key || (ek != null && key.equals(ek)))
                    return e.val;
            }
            else if (eh < 0)
            // 如果是树节点的话返回树查找
                return (p = e.find(h, key)) != null ? p.val : null;
            while ((e = e.next) != null) {
            // 否则查找链表
                if (e.hash == h &&
                    ((ek = e.key) == key || (ek != null && key.equals(ek))))
                    return e.val;
            }
        }
        return null;
    }
    
        public boolean containsKey(Object key) {
            return get(key) != null;//直接调用get(int key)方法即可，如果有返回值，则说明是包含key的
        }
        
        // Original (since JDK1.2) Map methods
        
        // 返回的是个估计值
            public int size() {// 旧版本方法，和推荐的mappingCount返回的值基本无区别
                long n = sumCount();
                return ((n < 0L) ? 0 :
                        (n > (long)Integer.MAX_VALUE) ? Integer.MAX_VALUE :
                        (int)n);
            }


    public V remove(Object key) {
        return replaceNode(key, null, null);
    }

    /*
     *如果Map中存在(key,value)节点，则用对象cd来代替，
     *如果value为空，则删除此节点。
     */
    final V replaceNode(Object key, V value, Object cv) {
        int hash = spread(key.hashCode());//计算hash值
        for (Node<K,V>[] tab = table;;) {//死循环，直到找到
            Node<K,V> f; int n, i, fh;
            if (tab == null || (n = tab.length) == 0 ||
                (f = tabAt(tab, i = (n - 1) & hash)) == null)//如果为空，则立即返回
                break;
            else if ((fh = f.hash) == MOVED)//如果检测到其它线程正在扩容，则先帮助扩容，然后再来寻找，可见扩容的优先级之高
                tab = helpTransfer(tab, f);
            else {
                V oldVal = null;
                boolean validated = false;
                synchronized (f) {  //开始锁住这个桶，然后进行比对寻找满足(key,value)的节点
                    if (tabAt(tab, i) == f) { //重新检查，避免由于多线程的原因table[i]已经被修改
                        if (fh >= 0) {//链表节点
                            validated = true;
                            for (Node<K,V> e = f, pred = null;;) {
                                K ek;
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {//满足条件就是找到key出现的节点位置
                                    V ev = e.val;
                                    if (cv == null || cv == ev ||
                                        (ev != null && cv.equals(ev))) {
                                        oldVal = ev;
                                        if (value != null)//value不为空，则更新值
                                            e.val = value;
                                        //value为空，则删除此节点
                                        else if (pred != null)
                                            pred.next = e.next;
                                        else
                                            setTabAt(tab, i, e.next);//符合条件的节点e为头结点的情况
                                    }
                                    break;
                                }
                                //更改指向，继续向后循环
                                pred = e;
                                if ((e = e.next) == null)//如果为到链表末尾了，则直接退出即可
                                    break;
                            }
                        }
                        else if (f instanceof TreeBin) {//树节点
                            validated = true;
                            TreeBin<K,V> t = (TreeBin<K,V>)f;
                            TreeNode<K,V> r, p;
                            if ((r = t.root) != null &&
                                (p = r.findTreeNode(hash, key, null)) != null) {
                                V pv = p.val;
                                if (cv == null || cv == pv ||
                                    (pv != null && cv.equals(pv))) {
                                    oldVal = pv;
                                    if (value != null)
                                        p.val = value;
                                    else if (t.removeTreeNode(p))
                                        setTabAt(tab, i, untreeify(t.first));
                                }
                            }
                        }
                    }
                }
                if (validated) {
                    if (oldVal != null) {
                        if (value == null)//如果删除了节点，则要减1
                            addCount(-1L, -1);
                        return oldVal;
                    }
                    break;
                }
            }
        }
        return null;
    }
```