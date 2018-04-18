package anything.leetcode.mid;

public class Problem5 {

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int begin = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                begin = i;
                maxLen = 2;
                dp[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= s.length(); len ++ ){
            for(int i = 0; i+ len <= s.length(); i ++){
                if(dp[i+1][i+len-2] && s.charAt(i) == s.charAt(i+len-1) ){
                    dp[i][i+len-1] = true;
                    begin = i;
                    maxLen = len;
                }
            }
        }
        if(maxLen > 0){
            return s.substring(begin,begin+maxLen);
        }else {
            return null;
        }
    }
}
