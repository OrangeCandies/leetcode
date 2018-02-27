package anything;

public class Leetcode538 {
    class Solution {
        public TreeNode convertBST(TreeNode root) {
            convert(root);
            return root;
        }
        private int sum = 0;
        private void convert(TreeNode root){
            if(root == null){
                return;
            }
            convert(root.right);
            root.val += sum;
            sum = root.val;
            convert(root.left);
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
