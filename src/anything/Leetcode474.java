package anything;

public class Leetcode474 {

    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m+1][n+1];
            for (String s : strs) {
                int cnt0 = 0;
                int cnt1 = 0;
                for (char c : s.toCharArray()) {
                    if (c == '1') {
                        cnt1++;
                    } else {
                        cnt0++;
                    }
                }
                for(int i = m; i >= cnt0; i--){
                    for(int j = n; j >= cnt1; j--){
                        dp[i][j] = Math.max(dp[i][j],dp[i-cnt0][j-cnt1] + 1);
                    }
                }
            }
            return dp[m][n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode474().new Solution();
        int maxForm = solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        System.out.println(maxForm);
    }


}
