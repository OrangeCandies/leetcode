package anything.leetcode.mid;

import java.util.Arrays;

public class Problem31 {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            if(coins == null || coins.length == 0 || amount <= 0)  {
                return 0;
            }
            int[] dp = new int[amount+1];
            Arrays.fill(dp,-1);
            for(int i : coins) {
                if(i <= amount)
                    dp[i] = 1;
            }
            for(int i = 1; i <= amount ; i++ ) {
                for(int j =0 ; j < coins.length ; j ++) {
                    if(i >= coins[j] && dp[i-coins[j]] != -1){
                        if(dp[i] != -1)
                            dp[i] = Math.min(dp[i],1 + dp[i - coins[j]]);
                        else
                            dp[i] = 1 + dp[i-coins[j]];
                    }
                }
            }

            return dp[amount];
        }
    }
}
