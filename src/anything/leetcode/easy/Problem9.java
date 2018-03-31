package anything.leetcode.easy;

public class Problem9 {

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            if(board == null || board.length == 0){
                return false;
            }
            if(validBell(board) && validColumn(board) && validRow(board)){
                return true;
            }
            return false;
        }

        private boolean validRow(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                boolean[] test = new boolean[10];
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    } else if (board[i][j] - '0' > 0 && board[i][j] - '0' <= 9) {
                        if (test[board[i][j] - '0']) {
                            return false;
                        }
                        test[board[i][j] - '0'] = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean validColumn(char[][] board) {
            for (int j = 0; j < board.length; j++) {
                boolean[] test = new boolean[10];
                for (int i = 0; i < board[0].length; i++) {
                    if (board[i][j] == '.') {
                        continue;
                    } else if (board[i][j] - '0' > 0 && board[i][j] - '0' <= 9) {
                        if (test[board[i][j] - '0']) {
                            return false;
                        }
                        test[board[i][j] - '0'] = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean validBell(char[][] board) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    boolean[] test = new boolean[10];
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++){
                            if (board[i*3+x][j*3+y] == '.') {
                                continue;
                            } else if (board[i*3+x][j*3+y] - '0' > 0 && board[i*3+x][j*3+y] - '0' <= 9) {
                                if (test[board[i*3+x][j*3+y] - '0']) {
                                    return false;
                                }
                                test[board[i*3+x][j*3+y] - '0'] = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }

    }


    public static void main(String[] args) {
        char [][] test = new char[][]{{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
        Solution solution = new Problem9().new Solution();
        boolean validSudoku = solution.isValidSudoku(test);
        System.out.println(validSudoku);
    }

}
