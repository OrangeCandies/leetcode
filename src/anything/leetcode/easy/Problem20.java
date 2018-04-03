package anything.leetcode.easy;

import linkedList.ListNode;

public class Problem20 {

    class Solution {
        public void deleteNode(ListNode node) {
            if (node == null || node.next == null) {
                return;
            }
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
