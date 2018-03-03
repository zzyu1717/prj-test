package interview.exerciseProblem;

import interview.sort.util.SortUtil;

import java.util.Random;

/**
 * get Kth max number using quick sort of thinking
 */
public class SelectKthMaxNumber {
    private final static Random random = new Random();

    public static int getKthMaxNumber(int[] arr, int K) {
        if (K >= 0 && K < arr.length) {
            return quickSort(arr, 0, arr.length - 1, K);
        }
        return -1;
    }

    // sorting range [l,r]
    private static int quickSort(int[] arr, int l, int r, int K) {
        if (l == r) {
            return arr[l];
        }

        int p = partition(arr, l, r);
        /**
         * arr[l,p-1] > v and arr[p+1, r] <= v
         */
        if (K == p) {
            return arr[p];
        } else if (K > p) {
            return quickSort(arr, p + 1, r, K);
        } else {
            return quickSort(arr, l, p - 1, K);
        }
    }

    // DESC order.
    private static int partition(int[] arr, int l, int r) {
        SortUtil.swap(arr,l,(int)Math.random()*(r-l+1)+l);
        // set arr[l] as the pivot
        int v = arr[l];
        // split [l+1,j] > v and [j+1,i-1] <= v
        // init two array range is empty.
        int j = l;
        for (int i = l+1; i <= r; i++) {
            // when arr[i] >= v, only execute i++ is pretty good.we needn't do others.
            if (arr[i] > v) {
                SortUtil.swap(arr,i,++j);// ++j == (j+1;j++;)
            }

        }
        // put pivot v in suitable place
        SortUtil.swap(arr,l,j);

        return j;
    }

}
