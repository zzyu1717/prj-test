package interview.sort.advance;

import interview.sort.AbstractSort;

import java.util.Random;

public class QuickSort extends AbstractSort {

    private final Random random = new Random();

    public QuickSort(String sortName) {
        super(sortName);
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr,0,arr.length-1);    
    }

    // quick sort [l,r]
    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return ;
        }

        int p = partition(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    // partition [l,r]

    /**
     * get index p which can make arr[l,p-1] < arr[p] and arr[p+1,r] > arr[p]
     * @param arr
     * @param l
     * @param r
     * @return index p
     */
    private int partition(int[] arr, int l, int r) {
        // set arr[l] as random pivot.
        swap(arr,l,random.nextInt(r-l+1)+l);
        // set arr[l] as the pivot
        int v = arr[l];
        // split [l+1,j] < v and [j+1,i-1] > v
        // init two array range is empty.
        int j = l;
        for (int i = l+1; i <= r; i++) {
            // when arr[i] >= v, only execute i++ is pretty good.we needn't do others.
            if (arr[i] < v) {
                swap(arr,i,++j);// ++j == (j+1;j++;)
            }

        }
        // put pivot v in suitable place
        swap(arr,l,j);

        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
