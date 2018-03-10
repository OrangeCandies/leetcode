package anything;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode107 {
    class Solution {

        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<List<Integer>> list = new LinkedList<>();
        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            getQueue(root);
            return list;
        }

        private void getQueue(TreeNode root){
            if(root == null){
                return ;
            }
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                LinkedList<Integer> ans = new LinkedList<>();

                for(int i = 0; i < size ; i++){
                    TreeNode poll = q.poll();
                    if(poll.left != null){
                        q.add(poll.left);
                    }
                    if(poll.right != null){
                        q.add(poll.right);
                    }
                    ans.add(poll.val);
                }

                list.addFirst(ans);
            }
        }


    }

}
