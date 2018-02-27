package anything;

public class Leetcode746 {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] answer = new int[cost.length];
            int sz = cost.length;
            answer[sz-1] = cost[sz-1];
            for(int i = sz-2; i>=0; i--){
                answer[i] = cost[i]+Math.min(answer[i+1],(i+2>=sz?0:answer[i+2]));
            }
            int ans = answer[0];
            if(sz>=2){
                ans = Math.min(answer[0],answer[1]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {

       String a = "abc";
       String e = "abc";
        System.out.println(a == e);
       String b = new String(a);
       String c = new String(a);
        System.out.println(a == b);
        System.out.println(c == b);
    }
}
