package anything;

public class LeetCode53 {

    class Solution {
        public int maxSubArray(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int res = 0;
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++){
                res += nums[i];
                if(res > maxValue){
                    maxValue = res;
                }
                if(res < 0){
                    res = 0;
                }
            }
            return maxValue;
        }
    }

    public static void main(String[] args) {
        Solution solution = new LeetCode53().new Solution();
        int [] data = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = solution.maxSubArray(data);
        System.out.println(i);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
             e.addSuppressed();
        }
    }
}
