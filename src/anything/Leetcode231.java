package anything;

public class Leetcode231 {

    class Solution {
        public boolean isPowerOfTwo(int n) {

            if(n <= 0 ){
                return false;
            }
            return (n & (n-1)) == 0;
        }
    }
}
