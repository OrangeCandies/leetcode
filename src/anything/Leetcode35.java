package anything;

public class Leetcode35 {

    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            return l;
        }
    }


}
