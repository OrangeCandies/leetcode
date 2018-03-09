package anything;

public class Leetcode104 {

    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            if(root.left == null){
                return maxDepth(root.right)+1;
            }
            if(root.right == null){
                return maxDepth(root.left)+1;
            }
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            return l > r ? l+1 : r+1;
        }
    }
}
