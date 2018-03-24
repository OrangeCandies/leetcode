package anything;

public class Leetcode264 {

    class Solution {
        public int nthUglyNumber(int n) {
            int[] ids = new int[3];
            int[] ans = new int[n];

            ans[0] = 1;

            for(int i =1; i < n ; i++){
                int a = ans[ids[0]] * 2;
                int b = ans[ids[1]] * 3;
                int c = ans[ids[2]] * 5;

                int min = Math.min(a,Math.min(b,c));
                ans[i] = min;
                if(min == a) ids[0] ++;
                if(min == b) ids[1] ++;
                if(min == c) ids[2]++;
            }

            return ans[n-1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode264().new Solution();
        int i = solution.nthUglyNumber(120);
        System.out.println(i);
    }


}
