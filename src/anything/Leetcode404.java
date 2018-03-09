package anything;

public class Leetcode404 {
    class Solution {
        int sum = 0;
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null){
                return 0;
            }
            sum(root,false);
            return sum;
        }
        private void sum(TreeNode root, boolean isLeft){
            if(root == null){
                return;
            }
            if(root.left == null && root.right == null && isLeft){
                sum += root.val;
                return;
            }
            sum(root.left,true);
            sum(root.right,false);

        }
    }
}
