package interview.heap;

import interview.sort.util.SortUtil;

public class MaxHeap {
    private int capacity;
    private  int count;
    private int[] items;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.items = new int[capacity+1]; // max heap start form index 1.
    }

    public void insert(int item) {
        if (count > capacity) {
            return;
        }
        items[++count] = item;
        // adjust max heap.
        shiftUp(count);
    }

    private void shiftUp(int k) {
        int item = items[k]; // insert position.
        while (k > 1 && items[k/2] < item) {
            items[k] = items[k/2];
            k /= 2;
        }
        items[k] = item;
    }

    public int extractMax() {
        int max = items[1];
        SortUtil.swap(items,1,count--);
        shiftDown(1);
        return max;
    }

    private void shiftDown(int k) {
        int item = items[k];
        while (2*k <= count) { // having child
            int j = 2*k;
            if (j+1 <= count && items[j+1] > items[j])  j++; // having right child and value of right child greater than left.
            if (item >= items[j]) break; // parent greater than child.
            items[k] = items[j];
            k = j;
        }
        items[k] = item;
    }

}
