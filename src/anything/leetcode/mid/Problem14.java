package anything.leetcode.mid;

public class Problem14 {
  class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        int leftSize = treeSize(root.left);
        if(k == leftSize + 1){
            return root.val;
        }else if(leftSize+1  >  k){
            return kthSmallest(root.left,k);
        }else{
            return kthSmallest(root.right,k-leftSize-1);
        }
    }
    
    private int treeSize(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + treeSize(root.left) + treeSize(root.right);
    }
    
}
  
}
