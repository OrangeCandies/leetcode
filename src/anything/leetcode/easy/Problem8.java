package anything.leetcode.easy;

public class Problem8 {

    class Solution {
        public void moveZeroes(int[] nums) {
            int pos0 = 0;
            int posNow = 0;
            if(nums == null || nums.length == 0){
                return;
            }
            for(int i = 0; i < nums.length; i ++ ){
                if(nums[i] != 0){
                    nums[pos0++] = nums[i];
                }
            }
            for(;pos0<nums.length;pos0++){
                nums[pos0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int []testData = new int[]{0, 1, 0, 3, 12};
        Solution solution = new Problem8().new Solution();
        solution.moveZeroes(testData);
        for(int i: testData){
            System.out.println(i);
        }
    }
}
