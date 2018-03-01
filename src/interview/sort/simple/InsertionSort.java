package interview.sort.simple;

import interview.sort.AbstractSort;

public class InsertionSort extends AbstractSort {

    public InsertionSort(String sortName) {
        super(sortName);
    }

    @Override
    public void sort(int[] arr) {
        // first element arr[0] is sorted
        for (int i = 1; i < arr.length; i++) {
            //sort [i,n)
            int min = arr[i];
            int j = i;
            for (; j >= 1 && min < arr[j-1]; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = min;
        }
    }

    // sorting range within [l,r]
    public static void sort(int[] arr, int l, int r) {
        for (int i = l+1; i <= r; i++) {
            int current = arr[i];
            int j = i;
            for (; j >= l+1 && current < arr[j-1]; j--) {
                arr[j] = arr[j-1]; // max element shift to right
            }
            arr[j] = current;
        }
    }
}
















