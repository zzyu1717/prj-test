package interview.heap;

import interview.sort.util.SortUtil;

public class MaxHeapTest {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
        int[] arr = SortUtil.randomArray(50, 0, 100);
        for (int i = 0; i < arr.length ; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(maxHeap.extractMax());
            System.out.print(" ");
        }
    }
}
