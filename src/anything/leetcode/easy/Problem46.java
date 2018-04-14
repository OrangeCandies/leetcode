package anything.leetcode.easy;

public class Problem46 {
    class Solution {
        public int missingNumber(int[] nums) {
            int target = 0;
            for(int i = 0 ; i < nums.length ; i ++ ){
                target ^= i;
            }
            for(int i : nums){
                target ^= i;
            }
            return target;
        }
    }
}
