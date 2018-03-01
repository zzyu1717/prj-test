package interview.sort.advance;

import interview.sort.AbstractSort;

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
        if (left >= right) {
            return ;
        }
        int mid = left + (right-left)/2;
        mergeSort(temp,arr,left,mid);
        mergeSort(temp,arr,mid+1,right);
        merge(temp,arr,left,mid,right);
    }
    //merge order sequence range within [left,mid] and [mid+1,right]
    private void merge(int[] temp,int[] arr, int left,int mid, int right) {
        // the index of left order sequence
        int i = left;
        // the index of right order sequence
        int j = mid + 1;
        // the initial index of temporary array
        int k = left;
        // the left and right part all exist.
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) { // <= : is stable
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) { // the left have remainder
            temp[k++] = arr[i++];
        }
        while (j <= right) { // the right have remainder
            temp[k++] = arr[j++];
        }
        // copy temp to arr.
        System.arraycopy(temp,left,arr,left,right-left+1);
    }
}
