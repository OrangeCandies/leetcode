package anything;

public class Leetcode437 {

    class Solution {
        private int number = 0;
        public int pathSum(TreeNode root, int sum) {
            if(root == null){
                return number;
            }
            return dfs(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
        }

        private int dfs(TreeNode root,int sum){
            int res = 0;
            if(root == null){
                return res;
            }
            if(sum == root.val){
                res ++;
            }
            res += dfs(root.left,sum-root.val);
            res += dfs(root.right,sum-root.val);

            return res;
        }
    }
}
