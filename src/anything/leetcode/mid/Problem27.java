package anything.leetcode.mid;

public class Problem27 {
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length-1;

            while(l <= r){
                int mid = ( r - l)/2 + l;
                if(nums[mid] == target) {
                    return mid;
                }else if(nums[mid] >= nums[l]){
                    if(nums[mid] > target && target >= nums[l] ){
                        r = mid-1;
                    }else{
                        l = mid+1;
                    }
                }else {
                    if(target > nums[mid] && target <= nums[r]){
                        l = mid + 1;
                    }else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

}
