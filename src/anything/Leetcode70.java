package anything;

public class Leetcode70 {

    class Solution {
        public int climbStairs(int n) {
            int t1 = 1;
            int t2 = 2;

            if(n == 1){
                return 1;
            }
            if(n == 2){
                return 2;
            }
            for(int i = 3; i <= n ; i++){
                int temp = t2;
                t2 = t1 + t2;
                t1 = temp;
            }
            return t2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode70().new Solution();
        int i = solution.climbStairs(4);
        System.out.println(i);
    }


}
