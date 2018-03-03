package interview.sort.advance;

import interview.sort.AbstractSort;
import interview.sort.simple.InsertionSort;
import interview.sort.util.SortUtil;

import java.util.Random;

/**
 * optimize sorting array with having lots of element to equal
 */
public class QuickSort3Ways extends AbstractSort {

    private final Random random = new Random();

    public QuickSort3Ways(String sortName) {
        super(sortName);
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // sorting range [l,r]
    private void quickSort(int[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        // set pivot
        SortUtil.swap(arr, l, random.nextInt(r - l + 1) + l);
        int v = arr[l];

        /**
         *  [l,r] split three part
         *
         *  1. arr[l+1,lt) < v; arr[lt,i) == v; arr[gt,r] > v. i is current iterative variable
         *
         *  2. initial value:
         *        lt = l+1;  i = lt; gt = r+1; all part array is empty.
         *
         *
         * l l+1       lt      i   gt       r
         *  +++++++++++++++++++++++++++++++++
         *  |   < v   |  == v | ... |  > v  |
         *  ++++++++++++++++++++++++++++++++
         *
         */
        int lt = l+1; // lt is first element equal v.
        int i = lt; // i is current element will be comparable
        int gt = r+1; // gt is first element great than v.
        while (i < gt) {
            if (arr[i] < v) {
                SortUtil.swap(arr,i,lt);
                i++;
                lt++;
            } else if (arr[i] > v) {
                SortUtil.swap(arr,i,gt-1); // one element before > v
                gt--;
            } else {
                i++;
            }
        }
        SortUtil.swap(arr,l,lt-1);
        /**
         * make arr[l,lt-1] < v, arr[gt,r] > v
         */
        quickSort(arr,l,lt-1);
        quickSort(arr,gt,r);

    }
}
