package anything.leetcode.mid;

public class Problem24 {

    class Solution {
        public int findPeakElement(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int begin = 0;
            int end = nums.length-1;
            while (begin <= end) {

                if(begin == end) {
                    return begin;
                }
                int mid = (end-begin)/2 + begin;
                if(nums[mid] < nums[mid+1]) {
                    begin = mid + 1;
                }else {
                    end = mid ;
                }
            }
            return 0;
        }
    }

}
