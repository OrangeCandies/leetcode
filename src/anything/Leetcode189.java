package anything;

public class Leetcode189 {

    class Solution {
        public void rotate(int[] nums, int k) {
            if(nums == null){
                return;
            }
            k = k % nums.length;
            rotate(nums,0,nums.length-k-1);
            rotate(nums,nums.length-k,nums.length-1);
            rotate(nums,0,nums.length-1);

        }


        private void rotate(int[] nums, int l, int r) {

            if(r <= l){
                return;
            }
            int mid = l + (r - l) / 2;
            while(l <= mid){
                int temp = nums[l];
                nums[l++] = nums[r];
                nums[r--] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode189().new Solution();
        int [] testDate = new int[]{1,2,3,4,5,6,7};
        solution.rotate(testDate,3);
        for(int i : testDate ){
            System.out.println(i);
        }
    }
}
