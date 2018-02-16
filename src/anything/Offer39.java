package anything;

public class Offer39 {
    public boolean IsBalanced_Solution(Offer32.TreeNode root) {
        if(root == null){
            return true;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int diff = left-right;
        if(diff<-1 || diff>1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

    }

    public int TreeDepth(Offer32.TreeNode root){
        if(root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left < right ? right+1:left+1;
    }
}
