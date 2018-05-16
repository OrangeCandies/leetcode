package anything.leetcode.mid;

public class Problem29 {

    class Solution {
        public boolean canJump(int[] nums) {
            if(nums == null || nums.length == 0) {
                return true;
            }
            int maxPos = nums[0];
            for(int i = 0; i <= maxPos && i < nums.length ; i ++) {
                maxPos = Math.max(maxPos,i+nums[i]);
            }

            if(maxPos >= nums.length-1) {
                return true;
            }else{
                return false;
            }
        }
    }
}
