package interview.DynamicProgramming;

/**
 * get max path sum form (i,j) to bottom
 */
public class TriangleMaxSum {
    /**
     *  recursive term
     * @param data
     * @param maxSums
     * @param i
     * @param j
     * @return
     */
    public static int maxSum(int[][] data,int[][] maxSums,int i, int j) {
        if (maxSums[i][j] != -1) {
            return maxSums[i][j];
        }

        if (i == data.length - 1) {
            return data[i][j];
        }

        maxSums[i][j] = data[i][j] + Math.max(maxSum(data, maxSums, i + 1, j),maxSum(data,maxSums,i+1,j+1));

        return maxSums[i][j];
    }

    // using iterate
    public static int maxSum(int[][] data) {
        int r = data.length;
        int c = data[0].length;
        for (int i = r-2; i >= 0; i--) { // last row is identical value.
            for (int j = 0; j < c-1; j++) {
                data[r-1][j] = data[i][j] + Math.max(data[r-1][j],data[r-1][j+1]);
            }
        }
        return data[r-1][0];
    }

    public static void main(String[] args) {
        // testCase data
        int[][] data = {{1,0,0,0},{4,5,0,0},{20,70,8,0},{150,3,10,2}};
        int[][] maxSums = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                maxSums[i][j] = -1;
            }
        }

        // Test
        int result = TriangleMaxSum.maxSum(data,maxSums,0,0);
        System.out.println(result);
        System.out.println(TriangleMaxSum.maxSum(data));
    }



}
