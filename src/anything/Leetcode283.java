package anything;

public class Leetcode283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int k = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    nums[k++] = nums[i];
                }
            }
            for(;k<nums.length;k++){
                nums[k] = 0;
            }
        }
    }
}
