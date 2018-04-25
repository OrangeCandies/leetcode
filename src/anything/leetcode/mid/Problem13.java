package anything.leetcode.mid;

import java.util.LinkedList;
import java.util.Queue;

public class Problem13 {
    class Solution {
        public void connect(TreeLinkNode root) {
            if(root == null){
                return;
            }
            Queue<TreeLinkNode> queue = new LinkedList();
            queue.add(root);
            while(!queue.isEmpty()){
                Queue<TreeLinkNode> next = new LinkedList<>();
                while (!queue.isEmpty()){
                    TreeLinkNode poll = queue.poll();
                    if(!queue.isEmpty()){
                        poll.next = queue.peek();
                    }else {
                        poll.next = null;
                    }
                    if(poll.left != null){
                        next.add(poll.left);
                    }
                    if(poll.right != null){
                        next.add(poll.right);
                    }
                }
                queue = next;
            }
        }
    }

}

class TreeLinkNode{
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
}
