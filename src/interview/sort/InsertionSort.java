package interview.sort;

public class InsertionSort extends AbstractSort {

    public InsertionSort(String sortName) {
        super(sortName);
    }

    @Override
    public void sort(int[] arr) {
        // first element arr[0] is sorted
        for (int i = 1; i < arr.length; i++) {
            //sort [i,n)
            int min = arr[i];
            int j = i;
            for (; j > 0 && min < arr[j-1]; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = min;
        }
    }
}
