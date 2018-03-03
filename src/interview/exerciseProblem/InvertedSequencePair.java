package interview.exerciseProblem;

import interview.sort.util.SortUtil;

public class InvertedSequencePair {

    /**
     *  use merge sort to get.
     * @return count of inverted sequence pair.
     */
    public static int getInvertedSequencePairCount(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n+1];
        for (int len = 1; len < n; len*=2) {

            for (int i = 0; i < n-len; i+=2*len) {
                if (arr[i + len - 1] > arr[i+len]) {
                    //merge [i,i+len-1] and [i+len,i+2*len-1]
                    merge(temp,arr,i,i+len,Math.min(i+2*len-1,n-1));
                }
            }
        }
        return temp[n];
    }

    // merge [l,mid-1] and [mid,r]
    private static void merge(int[] temp,int[] arr, int l, int mid, int r) {
        System.arraycopy(arr,l,temp,l,r-l+1);
        int n = temp.length - 1;
        int i = l;
        int j = mid;

        while (i <= mid-1 && j <= r) {
            if (temp[i] > temp[j]) {
                arr[l++] = temp[j++];
                // right remainder all great than temp[j++]
                temp[n] += mid-i;
            } else {
                arr[l++] = temp[i++];
            }
        }

        while (i <= mid-1) {
            arr[l++] = temp[i++];
        }
        while (j <= r) {
            arr[l++] = arr[j++];
        }
    }

}
