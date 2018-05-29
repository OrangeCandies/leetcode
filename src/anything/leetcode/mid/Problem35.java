package anything.leetcode.mid;

public class Problem35 {
    class Solution {
        public int trailingZeroes(int n) {

            /**
             *  f(n!) = k + f(k!)
             *  k = n/5
             *  ( 5 * (k-1), 5 * k ) must be a factor 2 * 5
             */
            if(n == 0) {
                return 0;
            }
            int k = n/5;
            return k + trailingZeroes(k);
        }
    }
}
