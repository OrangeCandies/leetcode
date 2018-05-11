package anything.leetcode.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem19 {

    class Solution {
        List<List<Integer>> ans = new LinkedList<>();
        public List<List<Integer>> subsets(int[] nums) {
            if(nums == null || nums.length == 0){
                return ans;
            }
            List<Integer> cur = new LinkedList<>();
            dfs(cur,nums,0);
            return ans;
        }

        private void dfs(List<Integer> cur , int [] nums , int size){
            sout(cur);
            ans.add(new ArrayList<>(cur));

            for(int j = size ; j < nums.length ; j ++){
                cur.add(nums[j]);
                dfs(cur,nums,j+1);
                cur.remove(cur.size()-1);
            }
        }

        private void sout(List<Integer> cur){
            cur.forEach( v -> System.out.print(v+" "));
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Problem19().new Solution();
        solution.subsets(new int[]{1,2,3,4,5});
    }
}
