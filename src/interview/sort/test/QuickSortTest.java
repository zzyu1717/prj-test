package interview.sort.test;

import interview.sort.advance.QuickSort;
import interview.sort.util.SortUtil;

public class QuickSortTest {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort("quick_sort");

        int[] arr = {};
        int[] arr1 = {1};
        int[] arr2 = {2,1};
        int[] arr3 = {2,3,1};
        quickSort.sort(arr);
        SortUtil.printArray(arr);
        quickSort.sort(arr1);
        SortUtil.printArray(arr1);
        quickSort.sort(arr2);
        SortUtil.printArray(arr2);
        quickSort.sort(arr3);
        SortUtil.printArray(arr3);

        int[] arr4 = SortUtil.randomArray(50,0,50);
        boolean result = SortUtil.isCorrect(quickSort,arr4);
        System.out.println(result);
    }
}
