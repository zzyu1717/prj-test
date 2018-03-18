package interview.DynamicProgramming;

import java.util.Arrays;

public class MaxLengthSubSequent {

    /**
     *
     * @param nums
     * @return count max length sub-sequent's element.
     */
    public static int  maxLen(int[] nums) {
        int[] maxLens = new int[nums.length];
        Arrays.fill(maxLens,1); // default max length equals 1.

        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    maxLens[i] = Math.max(maxLens[i],maxLens[j]+1);
            }
        }
        int max = 0;
        for (int num : maxLens) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {1,7,5,4,8,6,9};
        data = new int[]{1,2,3,4,5,6};
        System.out.println(MaxLengthSubSequent.maxLen(data));
    }
}
