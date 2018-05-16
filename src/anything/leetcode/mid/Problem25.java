package anything.leetcode.mid;

public class Problem25 {

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int [] ans = new int[2];
            ans[0] = findFirst(nums,target);
            ans[1] = findLast(nums,target);
            return ans;
        }

        private int findFirst(int[] nums, int target) {
            int l = 0;
            int r = nums.length-1;
            while( l <= r) {
                int mid = (r - l )/2 + l;
                if(nums[mid] == target && ( (mid == 0) || nums[mid-1] != target) ){
                    return mid;
                }else if(nums[mid] < target){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }

            return -1;
        }

        private int findLast(int [] nums, int target) {
            int l = 0;
            int r = nums.length-1;
            while(l <= r){
                int mid = ( r - l )/2  + l;
                if(nums[mid] == target && ( (mid == nums.length-1) || (nums[mid+1] != target) ) ) {
                    return mid;
                }else if(nums[mid] > target ){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            return -1;
        }

    }


}
