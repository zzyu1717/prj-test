package interview.sort.advance;

import interview.sort.AbstractSort;

public class ShellSort extends AbstractSort {
    private final int[] incres;
    public ShellSort(String sortName,int[] incres) {
        super(sortName);
        this.incres = incres;
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < incres.length ; i++) {
            int incre = incres[i];
            // assume first element is ordered. start sort [incre,n)
            for (int j = incre; j < arr.length; j++) {
                // the current element is inserted.
                int current = arr[j];
                int k = j;
                //sorted [0,k]
                for (; k >= incre && current < arr[k-incre]; k-=incre) {
                    arr[k] = arr[k-incre];
                }
                arr[k] = current;
            }
        }
    }
}
