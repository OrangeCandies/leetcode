package anything.leetcode.mid;

public class Problem36 {

    class Solution {
        public double myPow(double x, int n) {
            if(n == 0){
                return 1;
            }else if(n < 0){
                return 1/x * myPow(1/x,-(n+1));
            }else if(n == 1){
                return x;
            }

            double ret = myPow(x,n >> 1);
            ret = ret * ret;
            if( (n & 1) == 1 ){
                ret *= x;
            }
            return ret;

        }
    }

}
