package anything.leetcode.mid;

import java.util.Arrays;

public class Problem32 {


    class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums == null || nums.length == 0) {
                return 0;
            }
            int[]dp = new int[nums.length];
            int ans = 0;
            Arrays.fill(dp,1);
            for(int i = 0 ; i < nums.length; i ++ ) {
                for(int j = i-1; j >= 0; j --) {
                    if(nums[i] > nums[j])
                        dp[i] = Math.max(dp[i],1+dp[j]);
                }
                ans = Math.max(dp[i],ans);
            }
            return ans;
        }
    }
}
