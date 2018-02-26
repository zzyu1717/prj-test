package interview.sort.simple;

import interview.sort.AbstractSort;

public class BubbleSort extends AbstractSort {

    public BubbleSort(String sortName) {
        super(sortName);
    }

    @Override
    public void sort(int[] arr) {
        boolean isSorted = true;
        // have length-1 iteration comparing
        for (int i = arr.length-1; i >= 0; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
