package anything.leetcode.easy;

import anything.TreeNode;

public class Problem27 {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return function(root,Long.MAX_VALUE,Long.MIN_VALUE);
        }

        private boolean function(TreeNode root, long max, long min){
            if(root == null){
                return true;
            }
            if(root.val <= min || root.val >= max){
                return false;
            }
            return function(root.left,root.val,min) && function(root.right,max,root.val);
        }
    }


}
