package anything;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            Map map = new HashMap<Integer,Integer>();
            if(nums == null || nums.length == 0){
                return null;
            }
            for(int i =0 ; i< nums.length; i ++){
                if(map.containsKey(target-nums[i])){
                    ans[0] = (int) map.get(target-nums[i]);
                    ans[1] = i;
                    break;
                }else {
                    map.put(nums[i],i);
                }
            }
            return ans;
        }
    }
}
