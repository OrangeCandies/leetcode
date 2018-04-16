package anything.leetcode.mid;

public class Problem2 {

    class Solution {
        public void setZeroes(int[][] matrix) {

            if(matrix == null || matrix.length == 0){
                return;
            }

            boolean[] Y = new boolean[matrix.length];
            boolean[] X = new boolean[matrix[0].length];

            for(int i  = 0; i < matrix.length; i ++){
                for(int j = 0; j < matrix[0].length; j ++){
                    if(matrix[i][j] == 0){
                        X[j] = true;
                        Y[i] = true;
                    }
                }
            }

            for(int i = 0; i < matrix.length; i ++){
                for(int j =0; j < matrix[0].length; j ++){
                    if(X[j] || Y[i]){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
