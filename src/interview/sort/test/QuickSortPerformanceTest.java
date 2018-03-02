package interview.sort.test;

import interview.sort.advance.MergeSort;
import interview.sort.advance.QuickSort2;
import interview.sort.util.SortUtil;

import java.util.Arrays;

public class QuickSortPerformanceTest {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort("merger_sort");
        QuickSort2 quickSort = new QuickSort2("quick_sort");
        int n = 1000000,left=0,right=100;

        int[] arr = SortUtil.randomArray(n, left, right);
//        int[] arr = SortUtil.nearlyLineArray(n, left, right, 100);

        int[] copArr = Arrays.copyOf(arr, n);
        SortUtil.time(mergeSort,arr);
        SortUtil.time(quickSort,copArr);
    }
}
