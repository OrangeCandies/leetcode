package anything;

public class Leetcode111 {

    public static void main(String[] args) {
        TreeNode root = new Leetcode111().new TreeNode(1);
        root.right = new Leetcode111().new TreeNode(2);
        Solution1 solution1 = new Leetcode111().new Solution1();
        System.out.println( solution1.minDepth(root));
    }
    class Solution1 {
        public int minDepth(TreeNode root) {
            if(root == null)
                return 0;
            if(root.left == null && root.right == null){
                return 1;
            }
            int min = Integer.MAX_VALUE;
            if(root.left != null){
                min = minDepth(root.left);
            }
            if(root.right != null){
                min = Math.min(min,minDepth(root.right)+1);
            }
            return min;
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

