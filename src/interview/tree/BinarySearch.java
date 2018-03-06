package interview.tree;

public class BinarySearch {
    /**
     * @param arr sorted array
     * @return index of element in arr. -1 will be returned,if not exist.
     */
    public static int search(int[] arr, int element) {
        // search range [l,r]
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] == element) {
                return mid;
            }

            if (element > arr[mid]) {
                // [mid+1,r]
                l = mid + 1;
            } else {
                // [l,mid-1]
                r = mid - 1;
            }

        }
        return -1;
    }

    public static int searchRecursive(int[] arr, int element) {
        // [l,r]
        return searchRecursive(arr, 0, arr.length - 1, element);
    }

    private static int searchRecursive(int[] arr, int l, int r, int element) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] > element) {
            return searchRecursive(arr, l, mid - 1, element);
        } else if (arr[mid] < element) {
            return searchRecursive(arr, mid + 1, r, element);
        } else {
            return mid;
        }
    }

    /**
     * 二分查找法, 在有序数组arr中, 查找target
     * 如果找到target, 返回第一个target相应的索引index
     * 如果没有找到target, 返回比target小的最大值相应的索引, 如果这个最大值有多个, 返回最大索引
     * 如果这个target比整个数组的最小元素值还要小, 则不存在这个target的floor值, 返回-1
     *
     * @param arr
     * @param target
     * @return 返回值小于等于element
     */
    public static int floor(int[] arr, int target) {
        // search range [l+1,r]
        int l = -1;
        int r = arr.length - 1;

        while (l < r) {
            // 使用向上取整避免死循环
            int mid = l + (r - l + 1) / 2;
            if (arr[mid] >= target) {
                // [l+1,mid-1]
                r = mid - 1;
            } else {
                // [mid+1,r]
                l = mid;
            }
        }
        if (l + 1 < arr.length && arr[l + 1] == target) {
            return l + 1;
        }
        return l;
    }

    // 二分查找法, 在有序数组arr中, 查找target
    // 如果找到target, 返回最后一个target相应的索引index
    // 如果没有找到target, 返回比target大的最小值相应的索引, 如果这个最小值有多个, 返回最小的索引
    // 如果这个target比整个数组的最大元素值还要大, 则不存在这个target的ceil值, 返回整个数组元素个数n
    public static int ceil(int[] arr, int target) {
        // 寻找比target大的最小索引值
        // [l,r)
        int l = 0, r = arr.length;
        while (l < r) {
            // 使用普通的向下取整即可避免死循环
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target)
                //[mid+1,r)
                l = mid + 1;
            else // arr[mid] > target
                //[l,mid)
                r = mid;
        }
        // 如果该索引-1就是target本身, 该索引+1即为返回值
        if (r - 1 >= 0 && arr[r - 1] == target)
            return r - 1;

        // 否则, 该索引即为返回值
        return r;
    }

}
