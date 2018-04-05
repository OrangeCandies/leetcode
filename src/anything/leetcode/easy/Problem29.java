package anything.leetcode.easy;

import anything.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem29 {

    class Solution {

        private List<List<Integer>> ans = new LinkedList<>();
        private Queue<TreeNode> stack = new LinkedList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null){
                return ans;
            }
            stack.add(root);
            getLevelOrder();
            return ans;
        }

        private void getLevelOrder(){
            if(stack.isEmpty()){
                return;
            }else {
                Queue<TreeNode> newstack = new LinkedList<>();
                List<Integer> list = new ArrayList<>();
                while (!stack.isEmpty()){
                    TreeNode pop = stack.poll();
                    list.add(pop.val);
                    if(pop.left != null){
                        newstack.add(pop.left);
                    }
                    if(pop.right != null){
                        newstack.add(pop.right);
                    }
                }
                ans.add(list);
                stack = newstack;
                getLevelOrder();

            }
        }
    }

    
}
