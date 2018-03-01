package interview.sort.advance;

import interview.sort.AbstractSort;
import interview.sort.simple.InsertionSort;

import java.util.Arrays;

public class MergeSort extends AbstractSort{

    public MergeSort(String sortName) {
        super(sortName);
    }

    @Override
    public void sort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(temp,arr,0,arr.length-1);
    }

    //merger sort range in [left,right]
    private void mergeSort(int[] temp,int[] arr, int left, int right) {
        // for the little array, use insertSort sorting.
        if (right - left <= 15) {
            InsertionSort.sort(arr,left,right);
            return ;
        }
        int mid = left + (right-left)/2;
        mergeSort(temp,arr,left,mid);
        mergeSort(temp,arr,mid+1,right);
        // don't merge range within arr[mid] <= arr[mid+1] when the array is nearly order.
        if (arr[mid] > arr[mid+1]) {
            merge(temp,arr,left,mid,right);
        }
    }
    //merge order sequence range within [left,mid] and [mid+1,right]
    private void merge(int[] temp,int[] arr, int left,int mid, int right) {
        // copy arr to temp within range [left,right].
        System.arraycopy(arr,left,temp,left,right-left+1);
        // the index of left order sequence
        int i = left;
        // the index of right order sequence
        int j = mid + 1;
        // the left and right part all exist.
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) { // <= : is stable
                arr[left++] = temp[i++];
            } else {
                arr[left++] = temp[j++];
            }
        }
        while (i <= mid) { // the left have remainder
            arr[left++] = temp[i++];
        }
        while (j <= right) { // the right have remainder
            arr[left++] = temp[j++];
        }
    }
}
