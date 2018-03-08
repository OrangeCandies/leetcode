package anything;

import java.util.*;

public class Leetcode637 {
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Double> ans = new ArrayList<>();
            if(root == null){
                return null;
            }
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                double sum = 0.0;
                for(int i=0; i<size;i++){
                    TreeNode poll = queue.poll();
                    sum += poll.val;
                    if(poll.left != null)
                         queue.add(poll.left);
                    if(poll.right != null)
                         queue.add(poll.right);
                }
                ans.add(sum/size);
            }
            return ans;
        }
    }


}
