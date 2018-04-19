package anything.leetcode.mid;

public class Problem6 {

    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if(nums == null || nums.length <= 2){
                return false;
            }
            int max1 = Integer.MAX_VALUE;
            int max2 = Integer.MAX_VALUE;
            for(int i : nums){
                if( max1 >= i  ){
                    max1 = i;
                }else if(max2 >= i){
                    max2 = i;
                }else{
                    return true;
                }
            }
            return false;
        }
    }


}
