package anything;

import java.util.ArrayList;

public class Leetcode303 {

    class NumArray {


        private ArrayList<Integer> ans ;
        public NumArray(int[] nums) {
            if(ans == null){
                ans = new ArrayList<>(nums.length+1);
            }
            ans.add(0);
            for(int i=0;i<nums.length;i++){
                ans.add(ans.get(ans.size()-1)+nums[i]);
                System.out.println(ans.get(ans.size()-1) + "  " + nums[i]);
            }

        }
        public int sumRange(int i, int j) {
            return ans.get(j+1) - ans.get(i);
        }
    }

    public static void main(String[] args) {
        int [] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray solution = new Leetcode303().new NumArray(nums);
        int i = solution.sumRange(2, 5);
        System.out.println(i);
    }


}
