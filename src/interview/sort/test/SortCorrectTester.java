package interview.sort.test;

import interview.sort.*;
import interview.sort.simple.BubbleSort;
import interview.sort.simple.InsertionSort;
import interview.sort.simple.SelectionSort;
import interview.sort.util.SortUtil;

public class SortCorrectTester {
    public static void testCorrect(Sort sort) {
        int left = 0, right=50;
        // bound test
        int[] emptyArray = SortUtil.randomArray(0,left,right);
        SortUtil.testCorrectAndPrint(sort,emptyArray);

        int[] oneElementArray = SortUtil.randomArray(1,left,right);
        SortUtil.testCorrectAndPrint(sort,oneElementArray);

        int[] twoElementArray = SortUtil.randomArray(2,left,right);
        SortUtil.testCorrectAndPrint(sort,twoElementArray);

        int[] threeElementArray = SortUtil.randomArray(3,left,right);
        SortUtil.testCorrectAndPrint(sort,threeElementArray);

        int[] sortedArray = SortUtil.randomSortedArray(50,left,right);
        sort.sort(sortedArray);

        for (int i = 0; i < sortedArray.length-1; i++) {
            if (sortedArray[i] > sortedArray[i + 1]) {
                System.out.println(((AbstractSort)sort).getSortName()+" Test fifty sorted elements : false");
                return ;
            }
        }
        System.out.println(((AbstractSort)sort).getSortName()+" Test fifty sorted elements : true");

        int[] normalArray = SortUtil.randomArray(50,left,right);
        sort.sort(normalArray);

        for (int i = 0; i < normalArray.length-1; i++) {
            if (normalArray[i] > normalArray[i + 1]) {
                System.out.println(((AbstractSort)sort).getSortName()+" Test fifty normal elements : false");
                return ;
            }
        }
        System.out.println(((AbstractSort)sort).getSortName()+" Test fifty normal elements : true");
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort("selection_sort");
        InsertionSort insertionSort = new InsertionSort("insertion_sort");
        BubbleSort bubbleSort = new BubbleSort("bubble_sort");

        SortCorrectTester.testCorrect(selectionSort);
        SortCorrectTester.testCorrect(insertionSort);
        SortCorrectTester.testCorrect(bubbleSort);
    }
}
