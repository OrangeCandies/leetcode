package demo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LruHashMap extends LinkedHashMap {
    private int capcity;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private ReentrantLock reentrantLock = new ReentrantLock(false);

    public LruHashMap(int capcity) {
        super(capcity, DEFAULT_LOAD_FACTOR, true);
        this.capcity = capcity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capcity;
    }

    @Override
    public boolean containsKey(Object key) {
        reentrantLock.lock();
        try {
            return super.containsKey(key);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public Object get(Object key) {
        reentrantLock.lock();
        try {
            return super.get(key);
        }finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public Object put(Object key, Object value) {
        reentrantLock.lock();
        try {
            return super.put(key,value);
        }finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public int size() {
        reentrantLock.lock();
        try {
            return super.size();
        }finally {
            reentrantLock.unlock();
        }
    }
}
