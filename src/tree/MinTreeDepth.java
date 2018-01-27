package tree;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes
 * along the shortest path from the root node down to the nearest leaf node.
 */
public class MinTreeDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(new MinTreeDepth().run(root));
    }

    public int run(TreeNode root) {
       if(root == null){
           return 0;
       }else{
           return getDepth(root,0);
       }

    }

    private int getDepth(TreeNode root, int depth){
        int dep = depth;
        if(root.left == null && root.right==null){
            return depth+1;
        }
        int left = root.left == null ? Integer.MAX_VALUE: getDepth(root.left,depth+1);
        int rigth = root.right==null?Integer.MAX_VALUE:getDepth(root.right,depth+1);
        return left<rigth?left:rigth;
    }

}


