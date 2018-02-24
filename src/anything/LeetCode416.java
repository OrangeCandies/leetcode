package anything;

public class LeetCode416 {

    class Solution {
        // 0 未计算 1 可以 2 不可以
        int[][] ans;

        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if (sum % 2 == 0) {
                ans = new int[nums.length + 1][sum / 2 + 1];
                return bag(nums, nums.length - 1, sum / 2);
            } else {
                return false;
            }
        }

        public boolean tryPartition(int[] nums) {
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if (sum % 2 == 1) {
                return false;
            }
            int size = nums.length;
            int C = sum / 2;
            boolean[] ans = new boolean[C + 1];
            for (int i = 0; i < C + 1; i++) {
                ans[i] = (nums[i] == C);
            }

            for (int i = 1; i < size; i++) {
                for (int j = C; j >= nums[i]; j--) {
                    ans[j] = ans[j]||ans[j-nums[i]];
                }
            }
            return ans[C];

        }

        // 递归解法
        private boolean bag(int[] nums, int index, int cost) {

            if (cost == 0) {
                return true;
            }
            if (index < 0 || cost < 0) {
                return false;
            }

            if (ans[index][cost] != 0) {
                return ans[index][cost] == 1;
            }
            ans[index][cost] = (bag(nums, index - 1, cost) || bag(nums, index - 1, cost - nums[index]) ? 1 : 2);
            return ans[index][cost] == 1;
        }
    }

}
