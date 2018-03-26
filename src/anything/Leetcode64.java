package anything;

public class Leetcode64 {

    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int left, up;
                    if(j-1 < 0 && i-1 <0){
                        continue;
                    }
                    if (j - 1 < 0 ) {
                        grid[i][j] = grid[i-1][j] + grid[i][j];
                        continue;
                    }
                    if(i-1 < 0){
                        grid[i][j] = grid[i][j-1] +grid[i][j];
                        continue;
                    }

                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }

            }

            return grid[grid.length - 1][grid[0].length - 1];
        }
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Solution solution = new Leetcode64().new Solution();
        int i = solution.minPathSum(data);
        System.out.println(i);
    }

}
