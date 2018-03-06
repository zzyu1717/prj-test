package interview.heap;

import interview.sort.Sort;
import interview.sort.util.SortUtil;

import java.util.Arrays;

public class HeapSortTest {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort("heap_sort");
        HeapSort heapSort2 = new HeapSort("heap_sort2");
        int n = 1000000, left = 0, right = n;
        int[] arr = SortUtil.randomArray(n, left, right);
        int[] copyArr = Arrays.copyOf(arr,n);

//        boolean correct = SortUtil.isCorrect(heapSort, arr);
//        System.out.println(correct);


        SortUtil.testTimeAndCorrect(heapSort,arr);
        SortUtil.testTimeAndCorrect(heapSort2,copyArr);

    }
}
