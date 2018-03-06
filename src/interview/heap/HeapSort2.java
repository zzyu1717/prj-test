package interview.heap;

import interview.sort.AbstractSort;
import interview.sort.util.SortUtil;

/**
 * complex space o(1).
 */
public class HeapSort2 extends AbstractSort {
    public HeapSort2(String sortName) {
        super(sortName);
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = (n-1)/2; i >= 2 ; i--) {
            shiftDown(arr,i);
        }

        for (int i = n-1; i >= 0 ; i--) {
            SortUtil.swap(arr,i,0);
            shiftDown(arr,0);
        }
    }

    private void shiftDown(int[] arr,int i) {
        int n = arr.length;
        int item = arr[i];
        while (2*i+1 < n ) {
            int j = 2*i+1;
            if (j+1 < n && arr[j+1] > arr[j]) j++;
            if (item >= arr[j]) break;
            arr[i] = arr[j];
            i = j;
        }
        arr[i] = item;
    }
}
