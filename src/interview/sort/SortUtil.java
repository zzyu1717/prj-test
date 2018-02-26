package interview.sort;

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
        sort(arr);
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

    public static void time(Sort sort,int[] arr) {
        long startTime = System.currentTimeMillis();
        sort.sort(arr);
        System.out.println(((AbstractSort)sort).getSortName()+" elpased time: "
                + (System.currentTimeMillis()-startTime)/1000.0 + " s");
    }

    public static void testTimeAndCorrect(Sort sort,int[] arr) {
        time(sort,arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmep = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmep;
            }
        }
    }

}
