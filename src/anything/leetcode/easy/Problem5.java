package anything.leetcode.easy;

public class Problem5 {

    class Solution {
        public int singleNumber(int[] nums) {
            int  target = 0;
            for(int i  : nums){
                target ^= i;
            }
            return target;
        }
    }
}
