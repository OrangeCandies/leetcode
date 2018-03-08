package anything;

import java.util.Stack;

public class BinSercherTree {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
        }

    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){

            while(cur != null){
                System.out.println(cur.data);
                stack.push(cur);
                cur = cur.left;
            }
           if(!stack.empty()){
               TreeNode pop = stack.pop();
               cur = pop.right;
           }
        }
    }

    public void midOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.empty()){
                cur = stack.pop();
                System.out.println(cur.data);
                cur = cur.right;
            }
        }
    }
}
