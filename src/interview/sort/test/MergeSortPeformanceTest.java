package interview.sort.test;

import interview.sort.advance.MergeSort;
import interview.sort.advance.ShellSort;
import interview.sort.util.SortUtil;

import java.util.Arrays;

public class MergeSortPeformanceTest {
    public static void main(String[] args) {
        int[] incres = {131071,65535,32765,16383,8191,4095,1023,511,127,63,31,15,7,3,1};
        MergeSort mergeSort = new MergeSort("merger_sort");
        ShellSort shellSort = new ShellSort("shell_sort",incres);
        int n = 1000000,left=0,right=n;
        
        int[] arr = SortUtil.randomArray(n, left, right);
//        int[] arr = SortUtil.nearlyLineArray(n, left, right, 100);

        int[] copArr = Arrays.copyOf(arr, n);
        SortUtil.time(mergeSort,arr);
        SortUtil.time(shellSort,copArr);
    }
}
