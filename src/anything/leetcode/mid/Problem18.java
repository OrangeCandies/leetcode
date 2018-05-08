package anything.leetcode.mid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem18 {



    class Solution {
        List<List<Integer>> ans = new LinkedList<>();
        public List<List<Integer>> permute(int[] nums) {

            if(nums == null || nums.length == 0){
                return ans;
            }
            List<Integer> list = new LinkedList<>();
            Arrays.stream(nums).forEach(e -> list.add(e));
            getPermute(new LinkedList<>(),list);
            return ans;
        }

        private void getPermute(List<Integer> has,List<Integer> remain){
            if(remain.size() == 0){
                ans.add(has);
                has.forEach(e -> System.out.print(e));
                System.out.println();
                return;
            }
            for(int i = 0; i < remain.size(); i ++){
                has.add(remain.get(i));
                remain.remove(i);

                getPermute(has,remain);

                Integer remove = has.remove(has.size() - 1);
                remain.add(i,remove);
            }
        }







    }

    public static void main(String[] args) {
        Solution solution = new Problem18().new Solution();
        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});
    }
}
