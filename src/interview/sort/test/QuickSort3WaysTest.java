package interview.sort.test;

import interview.sort.advance.QuickSort3Ways;
import interview.sort.util.SortUtil;

public class QuickSort3WaysTest {
    public static void main(String[] args) {
        QuickSort3Ways quickSort = new QuickSort3Ways("quick_sort");

        int[] arr = {};
        int[] arr1 = {1};
        int[] arr2 = {2,1};
        int[] arr3 = {2,3,1,5,5,5,3,3,2};
        quickSort.sort(arr);
        SortUtil.printArray(arr);
        quickSort.sort(arr1);
        SortUtil.printArray(arr1);
        quickSort.sort(arr2);
        SortUtil.printArray(arr2);
        quickSort.sort(arr3);
        SortUtil.printArray(arr3);

        int[] arr4 = SortUtil.randomArray(1000,0,100);
        SortUtil.printArray(arr4);
        boolean result = SortUtil.isCorrect(quickSort,arr4);
        SortUtil.printArray(arr4);
        System.out.println(result);
    }

}
