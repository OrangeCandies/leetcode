package anything;

public class Leetcode33 {

    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    return mid;
                }else if (nums[l] <= nums[mid]) {
                    // nums[i] == nums[mid] 是因为数组会有相同的序列的情况
                    if (target >= nums[l] && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (target > nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }

            return -1;
        }
    }
}
