package anything;

public class Leetcode485 {

    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int number = 0;
            int maxNumber = 0;
            if(nums == null){
                return 0;
            }
            for (int i = 0; i < nums.length; i++){
                if(nums[i] == 1){
                    number ++ ;
                }else{
                    number = 0;
                }
                if(number > maxNumber){
                    maxNumber = number;
                }

            }

            return maxNumber;
        }
    }

}
