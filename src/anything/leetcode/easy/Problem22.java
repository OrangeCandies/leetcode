package anything.leetcode.easy;

import linkedList.ListNode;

public class Problem22 {


    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            ListNode next = null;
            ListNode cur = head;
            while(cur != null){
                next = cur.next;
                cur.next = newHead;
                newHead = cur;
                cur = next;
            }
            return newHead;
        }
    }


}
