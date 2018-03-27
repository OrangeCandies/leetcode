package anything;

public class Leetcode31 {

    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            for (int i = nums.length - 1; i >= 0; i--){
                for(int j = i-1; j >= 0; j--){
                    if(nums[j] < nums[i]){
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        return;
                    }
                }
            }
            for(int i = 0 ; i < nums.length/2; i++){
                int temp = nums[i];
                nums[i] = nums[nums.length-1-i];
                nums[nums.length-1-i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode31().new Solution();
        int [] testData = new int[]{1,3,2};
        solution.nextPermutation(testData);
        for(int i : testData){
            System.out.print(i+" ");
        }
    }
}
