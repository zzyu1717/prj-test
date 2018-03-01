package interview.sort.test;

import interview.sort.advance.MergeSort;
import interview.sort.util.SortUtil;

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort("merge_sort");

        int[] arr = {};
        int[] arr1 = {1};
        int[] arr2 = {2,1};
        int[] arr3 = {2,3,1};
        mergeSort.sort(arr);
        SortUtil.printArray(arr);
        mergeSort.sort(arr1);
        SortUtil.printArray(arr1);
        mergeSort.sort(arr2);
        SortUtil.printArray(arr2);
        mergeSort.sort(arr3);
        SortUtil.printArray(arr3);

        int[] arr4 = SortUtil.randomArray(4,0,50);
        System.out.println(Arrays.toString(arr4));
        mergeSort.sort(arr4);
        System.out.println(Arrays.toString(arr4));
    }
}
