package interview.sort.util;

import interview.sort.AbstractSort;
import interview.sort.Sort;

import java.util.Arrays;
import java.util.Random;

public class SortUtil {

    /**
     * generate array with n elements in [left,right] range.
     * @param n
     * @param left
     * @param right
     * @return
     */
    public static int[] randomArray(int n, int left,int right) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = left+random.nextInt(right-left+1);
        }
        return arr;
    }

    public static int[] randomSortedArray(int n, int left, int right) {
        int[] arr = randomArray(n,left,right);
        Arrays.sort(arr);
        return arr;
    }

    /**
     * generate the array of elements sequence nealy sorted.
     * @param n
     * @param left
     * @param right
     * @param offset offset is small,the array is nealy closed to line.
     * @return
     */
    public static int[] nearlyLineArray(int n, int left, int right,int offset) {
        Random random = new Random();
        int[] arr = randomArray(n,left,right);
        Arrays.sort(arr);
        for (int i = 0; i < offset; i++) {
            // generate two random array index
            int randomIndex1 = random.nextInt(n);
            int randomIndex2 = random.nextInt(n);
            // swap the value of random array value
            int temp = arr[randomIndex1];
            arr[randomIndex1] = arr[randomIndex2];
            arr[randomIndex2] = temp;
        }
        return arr;
    }

    public static void time(Sort sort, int[] arr) {
        long startTime = System.currentTimeMillis();
        sort.sort(arr);
        System.out.println(((AbstractSort)sort).getSortName()+" elpased time: "
                + (System.currentTimeMillis()-startTime)/1000.0 + " s");
    }

    public static void testTimeAndCorrect(Sort sort,int[] arr) {
        time(sort,arr);
        printArray(arr);
    }

    public static void testCorrectAndPrint(Sort sort,int[] arr) {
        sort.sort(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

}
