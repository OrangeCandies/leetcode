package anything;

public class Leetcode110 {

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
            if(Math.abs(getDepth(root.left)-getDepth(root.right)) > 1 ){
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }

        private int getDepth(TreeNode root){
            if(root == null){
                return 0;
            }
            int l = getDepth(root.left);
            int r = getDepth(root.right);

            return l > r ? l+1 : r+1;
        }
    }
}
