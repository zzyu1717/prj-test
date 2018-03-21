package interview.sort.simple;

public class BinarySearch {

    /**
     * 返回小于key的最大值
     * @param nums
     */
    public static int ceiling(int[] nums,int key) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi){
            int mid = lo + (hi-lo)/2;

            if (nums[mid] >= key) {
                hi = mid - 1;
            } else { // nums[mid] < key
                lo = mid + 1;
            }
        }
        return hi;
    }

    /**
     * 返回小于或等于key的最大值
     * @param nums
     */
    public static int ceiling2(int[] nums,int key) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                hi = mid - 1;
            } else { // nums[mid] < key
                lo = mid + 1;
            }
        }
        return hi;
    }
}
