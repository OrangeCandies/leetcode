package anything;

public class LeetCode198 {
    class Solution {
        public int rob(int[] nums) {

            if(nums == null || nums.length == 0){
                return 0;
            }
            int sz = nums.length;
            int[] answer = new int[sz + 1];
            for (int i = 0; i < sz + 1; i++) {
                answer[i] = 0;
            }
            answer[sz-1] = nums[sz-1];
            for(int i=sz-2; i>=0; i--){
                answer[i] = Math.max(answer[i+1],nums[i]+(i+2>=sz?0:answer[i+2]));
            }
            return answer[0];
        }

    }

    public static void main(String[] args) {
        Solution solution = new LeetCode198().new Solution();
        int[] tes = new int[]{2,1};
        int rob = solution.rob(tes);
        System.out.println(rob);
    }
}
