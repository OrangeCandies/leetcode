package anything;

import java.util.Stack;

public class Offer32 {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int input){
            value = input;
            left = null;
            right = null;
        }
    }

    public static TreeNode Convert(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode pre = null;
        TreeNode current = root;
        TreeNode firstNode = null;
        Stack<TreeNode> stack = new Stack<>();
        while(current!= null||!stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
           if(!stack.isEmpty()){
               current = stack.pop();
               current.left = pre;
               if(pre != null){
                   pre.right = current;
               } else{
                   firstNode = current;
               }
               pre = current;
               current = current.right;
           }
        }
        pre.right = null;
        return firstNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(12);
        root.left = new TreeNode(8);
        System.out.println(Convert(root).value);
    }

}
