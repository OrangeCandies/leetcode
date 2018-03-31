package anything.leetcode.easy;

public class Problem10 {

    class Solution {
        public void rotate(int[][] matrix) {

            if (matrix == null || matrix.length == 0) {
                return;
            }
            int length = matrix.length;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length - i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[length - j - 1][length - 1 - i];
                    matrix[length - j - 1][length - 1 - i] = temp;
                }
            }

            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - 1 - i][j];
                    matrix[matrix.length - 1 - i][j] = temp;
                }
            }
        }
    }


}
