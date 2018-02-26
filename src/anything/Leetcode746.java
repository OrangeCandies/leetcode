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
        Leetcode746 leetcode746 = new Leetcode746();
        Solution solution =  leetcode746.new Solution();
        int [] test = new int[]{1,0,0,0};
        int ans = solution.minCostClimbingStairs(test);
        System.out.println(ans);
    }
}
