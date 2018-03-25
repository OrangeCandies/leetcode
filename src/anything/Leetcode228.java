package anything;

import java.util.LinkedList;
import java.util.List;

public class Leetcode228 {
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new LinkedList<>();
            for(int i =0; i < nums.length; i ++){
                int count = 1;
                int to = i;
                for(int j = i + 1; j < nums.length; j ++){
                    if(nums[j] - nums[j-1] == 1){
                        count ++;

                        to = j;
                    }else{
                        break;
                    }
                }


                if(count >= 3){
                    ans.add(nums[i]+"->"+nums[to]);
                    i = to;
                }else{
                    ans.add(String.valueOf(nums[i]));
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode228().new Solution();
        List<String> strings = solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        for(String s : strings){
            System.out.println(s);
        }
    }

}
