package anything.leetcode.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem18 {



    class Solution {
        List<List<Integer>> ans = new LinkedList<>();
        public List<List<Integer>> permute(int[] nums) {

            if(nums == null || nums.length == 0){
                return ans;
            }
            for(int i =0; i < nums.length; i ++){
                for(int j = i+1; j < nums.length; j++){

                    ans.add(transfer(nums));
                    swap(nums,i,j);
                    ans.add(transfer(nums));
                    swap(nums,i,j);
                }
            }
            return ans;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private List<Integer> transfer(int[] nums) {
            List<Integer> list = new ArrayList<>(nums.length);
            for(int i : nums){
                list.add(i);
            }
            list.forEach( o -> System.out.print(o));
            System.out.println();
            return list;
        }


    }

    public static void main(String[] args) {
        Solution solution = new Problem18().new Solution();
        solution.permute(new int[]{1,2,3});
    }
}
