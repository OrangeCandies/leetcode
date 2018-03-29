package anything.leetcode.easy;

public class Problem1 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            int index = 0;
            int next = 1;
            while(next < nums.length){
                if(nums[index] == nums[next]){
                    next ++;
                }else{
                    nums[++index] = nums[next++];
                }
            }
            return index +1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Problem1().new Solution();
        int [] testData = new int[]{1, 1, 2};
        int i = solution.removeDuplicates(testData);
        for(int j = 0; j < i ; j ++){
            System.out.println(testData[j]);
        }

    }

}
