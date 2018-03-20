package anything;

public class Leetcode338 {
    class Solution {
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            ans[0] = 0;
            for (int i = 0; i < num + 1; i++) {
                ans[i] = ans[i / 2] + i % 2;
            }
            return ans;
        }
    }
}
