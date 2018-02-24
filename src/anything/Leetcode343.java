package anything;

public class Leetcode343 {
    class Solution {
        int[] ans;

        private int breakInteger(int n) {
            if (n == 1) {
                return 1;
            }
            int res = 1;
            if (ans[n] != 0) {
                return ans[n];
            }
            int maxValue;
            for (int i = 1; i < n; i++) {
                maxValue = Math.max(i * (n - i), i * breakInteger(n - i));
                res = Math.max(res, maxValue);
            }
            ans[n] = res;
            return ans[n];
        }

        public int integerBreak(int n) {
            ans = new int[n + 1];
            // return breakInteger(n);
            ans[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    ans[i] = maxThree(ans[i],j*(i-j),j*ans[i-j]);
                }
            }
            return ans[n];
        }

        private int maxThree(int a,int b,int c){
            return Math.max(a,Math.max(b,c));
        }
    }


}

