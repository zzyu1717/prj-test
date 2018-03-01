package interview.list;

/**
 * make linked list sorted by merge sort.
 */
public class LinkedListSort {

    public void sort(MyLinkedList list) {
        int n = list.getSize();
        // the length of sub-sequence from 1(inclusive) to n(exclusive).
        for (int len = 1; len < n; len*=2) {
            // sorted [i,i+len-1] and [i+len,i+2*len-1]
            for (int i = 0; i < n-len; i+=2*len) {
                merge(list,i,i+len-1,Math.min(i+2*len-1,n-1));
            }
        }
    }


    private void merge(MyLinkedList list, int i, int l, int r) {

        // merge [i,mid] and [mid+1,r]

    }
}
