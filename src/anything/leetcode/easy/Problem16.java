package anything.leetcode.easy;

public class Problem16 {

    class Solution {
        public int myAtoi(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            str = str.trim();
            long sum = 0;
            boolean flag = false;
            boolean isNeg = false;
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    sum *= 10;
                    sum += str.charAt(i) - '0';
                    if(sum > Integer.MAX_VALUE && !isNeg){
                        return Integer.MAX_VALUE;
                    }else if(sum *-1 < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                } else if ((str.charAt(i) == '+' || str.charAt(i) == '-') && !flag) {
                    if (str.charAt(i) == '-') {
                        isNeg = true;
                    }
                    flag = true;
                }else{
                    break;
                }
            }

            return isNeg ? -1 * (int) sum :  (int)sum;

        }
    }



      public static void main(String[] args) {
        Solution solution = new Problem16().new Solution();
        int i = solution.myAtoi("-2147483647");
        System.out.println(i);
    }
}
