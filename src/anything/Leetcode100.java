package anything;

public class Leetcode100 {
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null){
                return true;
            }
            if(p == null || q == null){
                return false;
            }

            return q.val == p.val ? isSameTree(p.left,q.left)&&isSameTree(p.right,q.right) : false;
        }
    }
}
