package anything.leetcode.mid;

import anything.TreeNode;

import java.util.Arrays;

public class Problem12 {

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder.length == 0){
                return null;
            }
            int mid = preorder[0];
            int x = getPos(inorder,mid);
            TreeNode root = new TreeNode(mid);
            root.left = x == 0 ? null : buildTree(Arrays.copyOfRange(preorder,1,x+1)
                    ,Arrays.copyOf(inorder,x));
            root.right = x == inorder.length-1 ? null : buildTree(Arrays.copyOfRange(preorder,x+1,preorder.length)
                    ,Arrays.copyOfRange(inorder,x+1,inorder.length));

            return root;
        }
    }

    public static int getPos(int[] ans, int v){
       for(int i=0; i < ans.length; i++){
           if(ans[i] == v){
               return i;
           }
       }
       return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Problem12().new Solution();
        int [] date = new int[]{3, 9, 20, 15, 7};

       TreeNode treeNode = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

       System.out.println(treeNode.val);
    }

}
