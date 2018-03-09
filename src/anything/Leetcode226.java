package anything;

public class Leetcode226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            return root;
        }
    }
}
