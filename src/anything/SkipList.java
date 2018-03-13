package anything;

import java.util.Random;

public class SkipList<K extends Comparable, V> {

    private static final int MAX_LEAVE = 8;

    private SkipNode<K, V> head;
    private int maxleave;
    private int size;
    private Random random = new Random();

    public SkipList() {
        maxleave = 1;
        size = 0;
        head = new SkipNode<K, V>(null, null, MAX_LEAVE);
    }

    public void insert(K key, V value) {
        int i = maxleave - 1;
        int j = 0;
        SkipNode cur = head;
        SkipNode[] temp = new SkipNode[MAX_LEAVE]; // 保存每层向下跳转的位置

        while (i >= 0) {
            while (cur.pleave[i] != null) {
                if (key.compareTo(cur.pleave[i]) >= 0) {
                    cur = cur.pleave[i];
                } else {
                    break;
                }
            }
            temp[j++] = cur;
            i--;
        }

        i = 0;
        int randomLeave = random();
        maxleave = maxleave > randomLeave ? maxleave : randomLeave;
        SkipNode newNode = new SkipNode(key, value, randomLeave);
        for (int k = 0; k < randomLeave; k++) {
            if (k < j) {
                newNode.pleave[k] = temp[j - k - 1].pleave[k];
                temp[j - k - 1].pleave[k] = newNode.pleave[k];
            } else {
                head.pleave[k] = newNode;
            }
        }
        size++;
    }

    public boolean earse(K key){
        int i = maxleave - 1;
        int j = 0;
        SkipNode cur = head;
        SkipNode[] temp = new SkipNode[MAX_LEAVE];


        while (i >= 0) {
            while (cur.pleave[i] != null) {
                if (key.compareTo(cur.pleave[i]) >= 0) {
                    cur = cur.pleave[i];
                } else {
                    break;
                }
            }
            temp[j++] = cur;
            i--;
        }

        if(cur.pleave[0]!= null && cur.pleave[0].key ==key){
            cur = cur.pleave[0];
            int leve = cur.leaveSize;
            SkipNode del = cur;
            for(i =0 ; i < leve; i++){
                temp[j-i-1].pleave[i] = cur.pleave[i];
            }
            while(maxleave > 1){
                if(head.pleave[maxleave-1] == null){
                    maxleave -- ;
                }else{
                    break;
                }
            }
            if(size > 0){
                size --;
            }
        }

        return false;
    }

    public boolean find(K key, V value) {
        int i = maxleave - 1;
        SkipNode cur = head;
        while (i >= 0) {
            while (cur.pleave[i] != null) {
                if (key.compareTo(cur.pleave[i].key) >= 0) {
                    cur = cur.pleave[i];
                } else {
                    break;
                }
            }
            i--;
        }
        i = 0;
        if (cur.value == key) {
            return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }


    private int random() {
        int leave = 0;
        while (random.nextBoolean() && leave < maxleave) {
            leave++;
        }
        return leave;
    }

    static class SkipNode<K, V> {
        K key;
        V value;
        int leaveSize;
        SkipNode[] pleave;

        public SkipNode(K key, V value, int leaveSize) {
            this.key = key;
            this.value = value;
            this.leaveSize = leaveSize;
            this.pleave = new SkipNode[leaveSize];
        }
    }

}
