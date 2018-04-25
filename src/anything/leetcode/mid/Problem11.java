package anything.leetcode.mid;

import anything.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem11 {

    class Solution {
        private List<List<Integer>> ans = new LinkedList<>();
        private Stack<TreeNode> stack = new Stack<>();
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null){
                return ans;
            }
            stack.add(root);
            while(!stack.isEmpty()){
                List<Integer> row = new LinkedList<>();
                Stack<TreeNode> next = new Stack<>();
                while (!stack.isEmpty()){
                    TreeNode pop = stack.pop();
                    row.add(pop.val);
                    if(pop.left != null){
                        next.add(pop.left);
                    }
                    if(pop.right != null){
                        next.add(pop.right);
                    }
                }
                stack = next;
                ans.add(row);
            }
            return ans;

        }
    }


}
