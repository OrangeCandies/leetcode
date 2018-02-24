package anything;

public class LeetCode198 {
    class Solution {

        int [] ans;
        public int rob(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            ans = new int[nums.length+1];
            for(int i=0;i<nums.length+1;i++){
                ans[i] = -1;
            }
            return tryRob(nums,0);
        }

        private int tryRob(int []nums, int index){
           if(index >= nums.length){
               return 0;
           }
           if(ans[index] != -1){
               return ans[index];
           }
           int res = 0;
           for(int i=index;i<nums.length;i++){
               res = Math.max(res,nums[i]+tryRob(nums,i+2));
           }
           ans[index] = res;
           return res;
        }
    }

    public static void main(String[] args) {
        LeetCode198 leetCode198 = new LeetCode198();
        Solution solution = leetCode198.new Solution();
        int [] test = new int[]{4,1,2,7,5,3,1};
        int a = solution.rob(test);
        System.out.println(a);
    }
}
