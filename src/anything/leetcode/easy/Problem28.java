package anything.leetcode.easy;

import anything.TreeNode;

public class Problem28 {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return  function(root,root);
        }

        private boolean function(TreeNode r1, TreeNode r2){
            if(r1 == null && r2 == null){
                return true;
            }
            if(r1 == null || r2 == null){
                return false;
            }
            return r1.val == r2.val && function(r1.left,r2.right) && function(r2.left,r1.right);
        }
    }


}
