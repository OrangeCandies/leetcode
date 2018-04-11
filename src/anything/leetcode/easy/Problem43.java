package anything.leetcode.easy;

public class Problem43 {

    class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {

            n <<= 1;
          //  n ^= 0xffffffff;
            n >>= 1;
            return n;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Problem43().new Solution();
        int i = solution.reverseBits(43261596);
        System.out.println(i);
    }
}
