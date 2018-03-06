package interview.heap;

import interview.sort.util.SortUtil;

public class IndexMaxHeapTester {
    public static void main(String[] args) {
        int[] data = {15,17,19,13,22,16,28,30,41,62};
        IndexMaxHeap indexMaxHeap = new IndexMaxHeap(data.length);
        for (int i = 0; i < data.length; i++) {
            indexMaxHeap.insert(i,data[i]);
        }
        // [10, 9, 5, 7, 8, 6, 2, 4, 3, 1]
        SortUtil.printArray(indexMaxHeap.getIndexs());
        // reverse should be [10, 7, 9, 8, 3, 6, 4, 5, 2, 1]
        SortUtil.printArray(indexMaxHeap.getReverse());
        // data
        SortUtil.printArray(indexMaxHeap.getData());

        /*for (int i = 0; i < 10; i++) {
            System.out.print(indexMaxHeap.extractMax());
            System.out.print(" ");
        }*/
        System.out.println();
        indexMaxHeap.change(0,35);
        SortUtil.printArray(indexMaxHeap.getData());
        SortUtil.printArray(indexMaxHeap.getIndexs());
    }
}
