package interview.sort.advance;

import interview.sort.AbstractSort;

public class MergeSortB2U extends AbstractSort{
    public MergeSortB2U(String sortName) {
        super(sortName);
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        // len(length) is initial length of order sub-sequence. exp:[1,2,4,8,16,32,64...]
        for (int len = 1; len < n; len *= 2) {

            for (int i = 0; i < n-len; i += 2*len) {
                //merge[i,i+len-1] and [i+len,i+2*len-1]
                // i+len < arr.length. guarantee pair occur
                // Math.min(i+2*len+1,arr.length-1) get last sub-sequence with length < len
                merge(temp,arr,i,i+len-1,Math.min(i+2*len-1,n-1));
            }
        }
    }

    private void merge(int[] temp, int[] arr, int l, int mid, int r) {

        System.arraycopy(arr,l,temp,l,r-l+1);
        /**
         * merge range with [l,mid] and [mid+1,r]
         */
        int i = l;
        int j = mid+1;
        while (i <= mid && j <= r) {
            if (temp[i] > temp[j]) {
                arr[l++] = temp[j++];
            } else {
                arr[l++] = temp[i++];
            }
        }
        while (i <= mid) {
            arr[l++] = temp[i++];
        }
        while (j <= r) {
            arr[l++] = temp[j++];
        }
    }
}
