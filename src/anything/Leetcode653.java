package anything;

import java.util.HashSet;
import java.util.Set;

public class Leetcode653 {
    class Solution {

        Set<Integer> set = new HashSet<>();
        public boolean findTarget(TreeNode root, int k) {
            if(root == null){
                return false;
            }
            boolean l = findTarget(root.left,k);
            if(set.contains(k-root.val)){
                return true;
            }else{
                set.add(root.val);
            }
            boolean r = findTarget(root.right,k);

            return l || r ;
        }

    }
}
