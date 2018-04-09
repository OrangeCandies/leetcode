package anything.leetcode.easy;

public class Problem41 {

    class Solution {
        public boolean isPowerOfThree(int n) {
           if(n <= 0){
               return false;
           }
           while(n > 1){
               if(n % 3 != 0){
                   return false;
               }
               n /= 3;
           }
           return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Problem41().new Solution();
        boolean powerOfThree = solution.isPowerOfThree(27);
        System.out.println(powerOfThree);
    }
}
