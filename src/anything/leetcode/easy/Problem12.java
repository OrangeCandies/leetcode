package anything.leetcode.easy;

public class Problem12 {
    class Solution {
        public int reverse(int x) {

            boolean isNeg = false;
            if(x < 0 ){
                isNeg = true;
                x *= -1;
            }
            int ans = 0;
            while(x > 0){
                if(ans != 0 && Integer.MAX_VALUE/ans < 10){
                    return 0;
                }
                ans *= 10;
                ans += x%10;

                x /= 10;
            }
            return isNeg?-1*ans : ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Problem12().new Solution();
        int reverse = solution.reverse(1534236469);
        System.out.println(reverse);
    }

}
