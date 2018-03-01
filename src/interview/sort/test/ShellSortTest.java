package interview.sort.test;

import interview.sort.advance.ShellSort;
import interview.sort.util.SortUtil;

public class ShellSortTest {
    public static void main(String[] args) {
        int[] incres = {31,15,7,3,1};
        ShellSort shellSort = new ShellSort("shell_sort",incres);

        int[] arr = {};
        int[] arr1 = {1};
        int[] arr2 = {2,1};
        int[] arr3 = {2,3,1};
        shellSort.sort(arr);
        SortUtil.printArray(arr);
        shellSort.sort(arr1);
        SortUtil.printArray(arr1);
        shellSort.sort(arr2);
        SortUtil.printArray(arr2);
        shellSort.sort(arr3);
        SortUtil.printArray(arr3);

        int[] arr4 = SortUtil.randomArray(50,0,50);
        boolean result = SortUtil.isCorrect(shellSort,arr4);
        System.out.println(result);
    }
}
