package anything;

import java.util.Arrays;

public class Leetcode628 {

    class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);

            int l = nums.length - 1;

            int ans = nums[l] * nums[l - 1] * nums[l - 2];

            ans = Math.max(ans, nums[l - 1] * nums[l] * nums[0]);
            ans = Math.max(ans, nums[0] * nums[1] * nums[l]);

            return ans;
        }
    }
}
