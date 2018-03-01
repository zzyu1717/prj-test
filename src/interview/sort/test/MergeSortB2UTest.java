package interview.sort.test;

import interview.sort.advance.MergeSort;
import interview.sort.advance.MergeSortB2U;
import interview.sort.advance.MergeSortB2U2;
import interview.sort.util.SortUtil;

import java.util.Arrays;

public class MergeSortB2UTest {
    public static void main(String[] args) {
        MergeSortB2U2 mergeSort = new MergeSortB2U2("merge_sort_b2u2");

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

        int[] arr4 = SortUtil.randomArray(50,0,50);
        boolean result = SortUtil.isCorrect(mergeSort,arr4);
        System.out.println(result);
    }
}
