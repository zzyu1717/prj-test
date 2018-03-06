package interview.heap;

import interview.sort.util.SortUtil;

import java.util.Arrays;

public class IndexMaxHeap {
    private int[] indexs;
    private int[] data;
    private int[] reverse;

    private int capacity;
    private int count;

    public IndexMaxHeap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.indexs = new int[capacity+1];
        this.reverse = new int[capacity+1];
        this.data = new int[capacity+1];
        Arrays.fill(reverse,0);

    }

    /**
     *  user start from 0.
     * @param i
     * @param val
     */
    public void insert(int i,int val) {
        if (count+1 > capacity || (i+1<1 || i+1 > capacity)) {
            return ;
        }
        i += 1;
        data[i] = val;
        indexs[count+1] = i;
        reverse[i] = count+1;
        count++;

        shiftUp(count);
    }

    private void shiftUp2(int i) {
        while (i/2 >= 1 && data[indexs[i]] > data[indexs[i/2]]) {
            swapIndex(i,i/2);
            i/=2;
        }
    }

    private void shiftUp(int i) {
        int j = indexs[i];
        while (i/2 >= 1 && data[indexs[i/2]] < data[j]) {
            indexs[i] = indexs[i/2];
            reverse[indexs[i]] = i;
            i/=2;
        }
        indexs[i] = j;
        reverse[indexs[i]] = i;
    }

    public int extractMax() {
        if (count <= 0) {
            return -1;
        }
        int result = data[indexs[1]];
        swapIndex(1,count);
        reverse[count] = 0;
        count--;
        shiftDown(1);
        return result;
    }
    // swap operate
    private void shiftDown2(int i) {
        while (2 * i <= count) {
            int j = 2 * i;
            if (j+1 <= count && data[indexs[j+1]] > data[indexs[j]]) j++;
            if (data[indexs[i]] >= data[indexs[j]]) break;
            swapIndex(i,j);
            i = j;
        }
    }
    // shift operate
    private void shiftDown(int i) {
        int index = indexs[i];
        while (2*i <= count) {
            int j = 2 * i;
            if (j+1 <= count && data[indexs[j+1]] > data[indexs[j]]) j++;
            if (data[index] >= data[indexs[j]]) break;
            indexs[i] = indexs[j];
            reverse[indexs[i]] = i;
            i = j;
        }
        indexs[i] = index;
        reverse[indexs[i]] = i;
    }

    private void swapIndex(int i,int j) {
        int t = indexs[i];
        indexs[i] = indexs[j];
        indexs[j] = t;

        reverse[indexs[i]] = i;
        reverse[indexs[j]] = j;
    }

    public void change(int i,int newItem) {
        if (contain(i)) {
            return ;
        }
        i += 1;
        data[i] = newItem;
        shiftDown(reverse[i]);
        shiftUp(reverse[i]);

    }

    public boolean contain(int i) {
        return reverse[indexs[i]] != 0;
    }

    public int[] getIndexs() {
        return Arrays.copyOfRange(indexs,1,count+1);
    }

    public int[] getReverse() {
        return Arrays.copyOfRange(reverse,1,count+1);
    }

    public int[] getData() {
        return Arrays.copyOfRange(data,1,count+1);
    }
}
