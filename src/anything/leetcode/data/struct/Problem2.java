package anything.leetcode.data.struct;

import anything.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            TreeNode cur = root;
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || cur != null){
                while(cur != null) {
                    list.add(cur.val);
                    stack.push(cur);
                    cur = cur.left;
                }
                if(!stack.isEmpty()) {
                    cur = stack.pop();
                    cur = cur.right;
                }
            }

            return list;
        }
    }
}
