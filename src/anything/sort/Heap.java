package anything.sort;

import java.util.Random;

public class Heap {

    private int size = 0;
    private int maxSize = 0;
    private int[] data;

    public Heap(int size) {
        maxSize = size;
        data = new int[size];
    }

    public void insert(int input) {
        if (size == maxSize) {
            resize();
        }
        int current = size;
        data[current] = input;
        shiftUp(current);
        size++;
    }



    public int pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("size aleady have no element");
        }
        size--;
        int e = data[0];
        data[0] = data[size];
        data[size] = e;

        shiftDown(0, size);
        return e;
    }



    private void resize() {
        maxSize = maxSize * 2;
        int[] newData = new int[maxSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    private void shiftUp(int current){
        int father = (current - 1) / 2;
        while (data[current] < data[father]) {
            int temp = data[current];
            data[current] = data[father];
            data[father] = temp;

            current = father;
            father = (father - 1) / 2;
        }
    }

    private void shiftDown(int pos, int size) {
        int l = pos * 2 + 1;
        int r = pos * 2 + 2;
        int minPos = pos;
        if (l < size && data[l] < data[minPos]) {
            minPos = l;
        }
        if (r < size && data[r] < data[minPos]) {
            minPos = r;
        }
        if (minPos != pos) {
            int temp = data[pos];
            data[pos] = data[minPos];
            data[minPos] = temp;

            shiftDown(minPos, size);
        }
    }
    public void heapify(){
        for(int i = size/2; i >= 0 ; i--){
            shiftDown(i,size);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(50);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            heap.insert(random.nextInt(1000));
        }
        heap.heapify();
        for (int i = 0; i < 100; i++) {
            System.out.print(heap.pop() + " ");
        }

    }
}
