package anything.leetcode.easy;

import java.util.HashMap;

public class Problem6 {

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : nums1) {
                if (map.containsKey(i)) {
                    int val = map.get(i);
                    map.put(i, val + 1);
                } else {
                    map.put(i, 1);
                }
            }

            HashMap<Integer, Integer> ans = new HashMap<Integer, Integer>();
            int size = 0;
            for (int i : nums2) {
                if (map.containsKey(i)) {
                    if (ans.containsKey(i)) {
                        int val = ans.get(i);
                        ans.put(i, val + 1);
                    } else {
                        ans.put(i, 1);
                    }

                    int n = map.get(i);
                    if (n == 1) {
                        map.remove(i);
                    } else {
                        map.put(i, n - 1);
                    }
                    size++;
                }
            }
            int[] answer = new int[size];
            int[] pos = {0};
            ans.forEach((key, val) -> {
                for (int i = 0; i < val; i++) {
                    answer[pos[0]++] = key;
                }
            });
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Problem6().new Solution();
        int[] intersect = solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for(int i : intersect){
            System.out.println(i);
        }
    }

}
