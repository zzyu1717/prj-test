package interview.heap;

import interview.sort.AbstractSort;

public class HeapSort extends AbstractSort {
    private MaxHeap maxHeap;

    public HeapSort(String sortName) {
        super(sortName);
    }

    @Override
    public void sort(int[] arr) {
        maxHeap = new MaxHeap(arr.length+1);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = arr.length-1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }
}
