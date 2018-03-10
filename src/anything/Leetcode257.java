package anything;

import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {
    class Solution {

        List<String> ans = new ArrayList<>();
        public List<String> binaryTreePaths(TreeNode root) {
            if(root == null){
                return ans;
            }
            depth(root,"");
            return ans;
        }

        private void depth(TreeNode root,String s){
            if(root == null){
                return;
            }
            s += root.val+"->";
            if(root.left == null && root.right == null){
                String sub = s.substring(0,s.length()-2);
                ans.add(sub);
                return;
            }
            depth(root.left,s);
            depth(root.right,s);

        }
    }
}
