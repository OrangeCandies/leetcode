package anything.leetcode.easy;

public class Problem35 {

    class Solution {
        public int maxSubArray(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int sum = 0;
            int maxValue = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length; i ++){
                sum += nums[i];
                if(sum  > maxValue){
                   maxValue = sum;
                }
                if(sum < 0){
                    sum = 0;
                }
            }
            return maxValue;
        }
    }




}
