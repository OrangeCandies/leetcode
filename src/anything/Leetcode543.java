package anything;

public class Leetcode543 {
    class Solution {

        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root == null){
                return 0;
            }
            getDepth(root);
            return max;

        }

        private int getDepth(TreeNode root){
            if(root == null){
                return 0;
            }
            if(root.left == null && root.right == null){
                return 1;
            }
            int l = getDepth(root.left);
            int r = getDepth(root.right);
            if(l+r+1 > max){
                max = l+r;
            }
            return l > r ? l+1 : r+1 ;
        }
    }
}
