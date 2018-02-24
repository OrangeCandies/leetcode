package anything;

public class Leetcode101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return functuin(root,root);
        }

        private boolean functuin(TreeNode r1, TreeNode r2){
            if(r1 == null && r2 == null){
                return true;
            }
            if(r1 == null || r2 == null){
                return false;
            }

            return r1.val == r2.val && functuin(r1.left,r2.right) && functuin(r2.left,r1.right);
        }

    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
