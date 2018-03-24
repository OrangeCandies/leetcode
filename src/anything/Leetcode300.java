package anything;

public class Leetcode300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {

            if(nums == null || nums.length == 0){
                return 0;
            }
            int dp[] = new int[nums.length];
            dp[0] = 1;
            int ans = 1;
            for (int i = 1; i < nums.length; i++) {
                int max = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if(nums[i] > nums[j]){
                        if (dp[j] > max) {
                            max = dp[j];
                        }
                    }
                }
                dp[i] = max + 1;
                if(ans < dp[i]){
                    ans = dp[i];
                }
            }
            return ans;
        }
    }

}
