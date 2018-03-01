package interview.sort.test;

import interview.sort.advance.MergeSort;
import interview.sort.util.SortUtil;

import java.util.Arrays;

public class MergeSortPeformanceTest {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort("merger_sort");
        int n = 10000000,left=0,right=n;
        int[] arr = SortUtil.randomArray(n, left, right);
        int[] copArr = Arrays.copyOf(arr, n);
        SortUtil.time(mergeSort,arr);
    }
}
