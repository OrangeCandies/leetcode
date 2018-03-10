package anything;

public class Leetcode671 {

    class Solution {
        int first = 0 ;
        int second = Integer.MAX_VALUE;
        boolean found = false;
        public int findSecondMinimumValue(TreeNode root) {
            if(root == null){
                return -1;
            }
            first = root.val;
            depth(root);
            if(found)
                return second;
            else
                return -1;
        }

        private void depth(TreeNode root){
            if(root == null){
                return;
            }else{
                if(root.val != first && root.val < second){
                    second = root.val;
                    found = true;
                }
                depth(root.left);
                depth(root.right);
            }
        }
    }
}
