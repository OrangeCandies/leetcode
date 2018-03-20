package anything;

public class Leetcode69 {

    class Solution {
        public int mySqrt(int x) {
            if(x <= 0 ){
                return 0;
            }
            long low = 1;
            long high = x/2+1;
            long mid = 0;
            while(low <= high){
                mid = low + (high-low)/2;
                if(mid * mid == x){
                    return (int)mid;
                }else if(mid * mid < x){
                    low =mid+1;
                }else {
                    high = mid+1;
                }
            }

            return (int)(low + high)/2;
        }
    }
}
