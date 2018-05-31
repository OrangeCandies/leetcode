package anything.leetcode.hard;

import java.util.LinkedList;
import java.util.List;

public class Problem2 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new LinkedList<>();
            if(matrix == null || matrix.length == 0) {
                return ans;
            }
            int clu = matrix[0].length;
            int row = matrix.length;

            boolean [][] tag = new boolean[row][clu];

            int size = row * clu;
            int pos = 0;
            int i = 0;
            int j = 0;
            ans.add(matrix[0][0]);
            tag[0][0] = true;
            pos ++;
            while(pos < size ){
                while( j+1  <  clu && !tag[i][j+1]) {
                    ans.add(matrix[i][++j]);
                    tag[i][j] = true;
                    pos ++ ;
                }
                while( i + 1 < row && ! tag[i+1][j]) {
                    ans.add(matrix[++i][j]);
                    tag[i][j] = true;
                    pos ++ ;
                }
                while( j-1 >= 0 && !tag[i][j-1]) {
                    ans.add(matrix[i][--j]) ;
                    tag[i][j] = true;
                    pos ++;
                }
                while( i-1 >= 0 && !tag[i-1][j] ) {
                    ans.add(matrix[--i][j]);
                    tag[i][j] = true;
                    pos ++;
                }
            }

            return ans;

        }
    }
}
