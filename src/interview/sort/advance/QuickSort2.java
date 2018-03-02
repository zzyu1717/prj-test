package interview.sort.advance;

import interview.sort.AbstractSort;
import interview.sort.simple.InsertionSort;
import interview.sort.util.SortUtil;

import java.util.Random;


public class QuickSort2 extends AbstractSort {
    private final Random random = new Random();

    public QuickSort2(String sortName) {
        super(sortName);
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (r -l <= 16 ) {
            InsertionSort.sort(arr,l,r);
            return ;
        }

        int p = partition(arr,l,r);

        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    private int partition(int[] arr, int l, int r) {
        // set random element as pivot
        SortUtil.swap(arr,l,random.nextInt(r-l+1)+l);
        int v = arr[l];

        // partition make arr[l+1,i) <= v and arr(j,r] >= v
        // init i、j to make two partition range array are empty.
        int i = l+1;
        int j = r;

        while(true) {
            while(i <= r && arr[i] < v) i++; // shift to left
            while(j >= l+1 && arr[j] > v) j--; // shift to right
            if (i > j) break;
            SortUtil.swap(arr,i++,j--);
        }
        SortUtil.swap(arr,l,j);
        return j;
    }


}
