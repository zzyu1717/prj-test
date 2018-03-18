package interview.heap;

import interview.sort.Sort;
import interview.sort.util.SortUtil;

import java.util.Arrays;

public class HeapSortTest {

    public static void main(String[] args) {
        //HeapSort heapSort = new HeapSort("heap_sort");
        HeapSort2 heapSort2 = new HeapSort2("heap_sort2");
        int n = 10, left = 0, right = n;
        int[] arr = SortUtil.randomArray(n, left, right);
        int[] copyArr = Arrays.copyOf(arr,n);

//        boolean correct = SortUtil.isCorrect(heapSort, arr);
//        System.out.println(correct);

        System.out.println(Arrays.toString(copyArr));
       // SortUtil.testTimeAndCorrect(heapSort,arr);
        SortUtil.testCorrectAndPrint(heapSort2,copyArr);

    }
}
