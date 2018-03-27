package anything;

public class Leetcode63 {

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null || obstacleGrid.length == 0) {
                return 0;
            }
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int[][] dp = new int[m][n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    boolean left = false;
//                    boolean up = false;
//                    if (j == 0 || j - 1 >= 0 && obstacleGrid[i][j - 1] == 1) {
//                        left = true;
//                    }
//                    if (i == 0 || i - 1 >= 0 && obstacleGrid[i - 1][j] == 1) {
//                        up = true;
//                    }
//                    if(i == 0  && j == 0 && obstacleGrid[0][0] == 1){
//                        dp[i][j] = 0;
//                        continue;
//                    }
//                    if (left && up) {
//                        dp[i][j] = 1;
//                    }
//
//                }
//            }
            dp[0][0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {


                    if (j - 1 >= 0 && obstacleGrid[i][j] == 0) {
                        dp[i][j] += dp[i][j - 1];
                    }

                    if (i - 1 >= 0 && obstacleGrid[i][j] == 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                }
            }

            return dp[m - 1][n - 1];
        }
    }


}
