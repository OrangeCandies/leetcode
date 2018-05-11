package anything.leetcode.mid;

public class Problem20 {

    class Solution {
        public boolean exist(char[][] board, String word) {
            if (board == null) {
                return false;
            }
            int width = board[0].length;
            int length = board.length;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean[][] flag = new boolean[length][width];
                    if (dfs(flag, board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(boolean[][] flag, char[][] board, int i, int j, String word, int depth) {
            flag[i][j] = true;
            if(depth == word.length()-1 && word.charAt(depth) == board[i][j]){
                return true;
            }
            if (depth >= word.length() || word.charAt(depth) != board[i][j]) {
                flag[i][j] = false;
                return false;
            }
            if (i - 1 >= 0 && !flag[i - 1][j]) {
                if (dfs(flag, board, i - 1, j, word, depth + 1)) {
                    return true;
                }
            }
            if (i + 1 < flag.length && !flag[i + 1][j]) {
                if (dfs(flag, board, i+1, j, word, depth + 1)) {
                    return true;
                }
            }
            if (j - 1 >= 0 && !flag[i][j - 1]) {
                if (dfs(flag, board, i, j-1, word, depth + 1)) {
                    return true;
                }
            }
            if (j + 1 < flag[0].length && !flag[i][j + 1]) {
                if (dfs(flag, board, i, j+1, word, depth + 1)) {
                    return true;
                }
            }
            flag[i][j] = false;
            return false;
        }
    }


    public static void main(String[] args) {
        char[][] borad = new char[][]{{'A','B'},{'C','D'}};
        Solution solution = new Problem20().new Solution();
        boolean abcced = solution.exist(borad, "CDBA");
        System.out.println(abcced);
    }
}
