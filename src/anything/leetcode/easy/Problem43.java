package anything.leetcode.easy;

public class Problem43 {

    class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int value = 0;
            for(int i =0; i < 32; i ++){
                if((n & 1) == 1){
                    value = (value << 1) + 1;
                    n >>= 1;
                }else{
                    value <<= 1;
                    n >>= 1;
                }
            }
            return value;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Problem43().new Solution();
        int i = solution.reverseBits(43261596);
        System.out.println(i);
    }
}
