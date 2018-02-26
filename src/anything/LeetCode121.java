package anything;

public class LeetCode121 {

    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length ==0){
                return 0;
            }
            int maxValue = 0;
            int minPrice = prices[0];
            for (int i = 1; i < prices.length; i++) {
                maxValue = Math.max(maxValue,prices[i]-minPrice);
                minPrice = Math.min(minPrice,prices[i]);
            }
            return maxValue>0?maxValue:0;
        }
    }


}
