package anything;

public class Leetcode5 {

    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            int maxLen = 1;
            int start = 0;

            boolean[][] dp = new boolean[s.length()][s.length()];

            // init one and two
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
                if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    start = i;
                    maxLen = 2;
                    dp[i][i + 1] = true;
                }
            }

            for (int l = 3; l <= s.length(); l++) {
                for (int j = 0; j <= len-l; j ++ ){
                    int from = j;
                    int to = j + l-1;

                    if(dp[from+1][to-1] && s.charAt(from) == s.charAt(to)){
                        dp[from][to] = true;
                        maxLen = l;
                        start = from;
                    }
                }
            }
            if(maxLen > 0){
                return s.substring(start,start+maxLen);
            }
            return null;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode5().new Solution();
        String cbbca = solution.longestPalindrome("aa");
        System.out.println(cbbca);
    }
}
