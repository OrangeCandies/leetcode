package anything.leetcode.easy;

public class Problem3 {

    class Solution {
        public void rotate(int[] nums, int k) {
            if(nums == null || nums.length == 0){
                return;
            }

            k = k % nums.length;
            rotate(nums,nums.length-k,nums.length-1);
            rotate(nums,0,nums.length-1-k);
            rotate(nums,0,nums.length-1);
        }

        private void rotate(int[] nums, int l, int r){
            for(int i = l; i <= (l + r )/2; i++){
                int temp = nums[i];
                nums[i] = nums[r-(i-l)];
                nums[r-(i-l)] = temp;
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Problem3().new Solution();
        int [] testData = new int[]{1,2,3,4,5,6,7};
        solution.rotate(testData,3);
        for(int i = 0 ; i < testData.length ; i ++){
            System.out.print(testData[i] +  " ");
        }
    }


}
