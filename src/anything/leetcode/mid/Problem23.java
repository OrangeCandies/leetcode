package anything.leetcode.mid;

import java.util.PriorityQueue;

public class Problem23 {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b) -> b-a);
            for (int i = 0; i < nums.length; i++) {
                queue.add(nums[i]);
            }
            int ans = 0;
            for(int i = 0 ; i < k ; i ++){
                ans = queue.poll();
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Problem23().new Solution();
        int kthLargest = solution.findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 3);
        System.out.println(kthLargest);
    }
}
