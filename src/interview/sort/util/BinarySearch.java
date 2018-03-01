package interview.sort.util;

public class BinarySearch {

    /**
     *  binary search the val in arr.
     * @param arr a sorted array
     * @param val wanted to search
     * @return index of arr where val is, -1 will be returned if not search
     */
    public int binarySearch(int[] arr, int val) {
        int a = 0;
        int b = arr.length;
        // loop invariants:[a,b) is valid range(a<=b).
        // val may only be within [a,b)
        // a==b,size = 0.
        while (a < b) {
            int m = a + (b-a)/2; //avoid the (a+b)/2 overflow;
            if (val < arr[m]) { //[a...m-1]
                // hold [a,b) ---> len([a,b)) = b-a; [a,a)==>empty range;[a,m)+[m,b)=[a,b);
                b = m;
            } else if (val > arr[m]) { //[m+1...b)
                a = m+1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int index = bs.binarySearch(new int[]{12,34,78,83,100},100);
        System.out.println(index);
    }
}
