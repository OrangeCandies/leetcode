package anything.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem4 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            boolean isExist = false;
            for(int i : nums){
                if(set.contains(i)){
                    isExist = true;
                    break;
                }else{
                    set.add(i);
                }
            }
            return isExist;
        }
    }
}
