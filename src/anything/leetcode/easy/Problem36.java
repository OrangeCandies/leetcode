package anything.leetcode.easy;

public class Problem36 {

    class Solution {
        public int rob(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int[] dp = new int[nums.length+1];
            dp[0] = nums[0];
            for(int i = 1; i < nums.length; i ++){
                dp[i] = Math.max(dp[i-1], (i-2>= 0 ? dp[i-2] : 0 )+ nums[i]);
               // System.out.println(dp[i] +"  " + dp[i-1]+"  "+((i-2>= 0 ? dp[i-2] : 0 )+" "+ nums[i]));
            }
            return dp[nums.length-1];
        }

    }

    public static void main(String[] args) {
        Solution solution = new Problem36().new Solution();
        int rob = solution.rob(new int[]{2, 1, 1, 2});
        System.out.println(rob);
    }
}