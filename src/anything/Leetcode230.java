package anything;

public class Leetcode230 {
    class Solution {

        int count = 0;
        int val = 0;
        int goal = 0;
        public int kthSmallest(TreeNode root, int k) {
            goal = k;
            if(root == null){
                return 0;
            }
            midVisit(root);
            return val;
        }

        private void midVisit(TreeNode root){
            if(root == null){
                return ;
            }

            if(root.left != null){
                midVisit(root.left);
            }
            count ++ ;
            if(count == goal){
                val = root.val;
            }
            if(root.right != null){
                midVisit(root.right);
            }
        }
    }
}
