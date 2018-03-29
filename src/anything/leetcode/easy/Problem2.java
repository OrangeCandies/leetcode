package anything.leetcode.easy;

public class Problem2 {

    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length == 0){
                return 0;
            }
            int profit = 0;
            for(int i =0; i < prices.length-1; i ++){
                if(prices[i+1] - prices[i] > 0){
                    profit += (prices[i+1] - prices[i]);
                }
            }
            return profit;
        }
    }


    public static void main(String[] args) {
        Solution solution  = new Problem2().new Solution();
        int i = solution.maxProfit(new int[]{1, 2});
        System.out.println(i);
    }

}
