package anything.leetcode.mid;

import anything.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem10 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while(!stack.isEmpty() || cur != null){
                while (cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
                if(!stack.isEmpty()){
                    cur = stack.pop();
                    ans.add(cur.val);
                }
                cur = cur.right;
            }
            return ans;
        }

    }


}
