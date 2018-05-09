package anything.leetcode.mid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem1 {

    class Solution {
        List<List<Integer>> lists = new LinkedList<>();

        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length == 0) {
                return lists;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = nums[i];
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == target * -1) {
                        List<Integer> list = Arrays.asList(target, nums[l], nums[r]);
                        lists.add(list);
                        l++;
                        while (l + 1 < nums.length && nums[l - 1] == nums[l]) {
                            l++;
                        }
                        r --;
                        while (r - 1 > 0 && nums[r + 1] == nums[r]) {
                            r--;
                        }
                    } else if (nums[l] + nums[r] + target < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }

            return lists;
        }
    }



}
