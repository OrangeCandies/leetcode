package anything.leetcode.easy;

import linkedList.ListNode;

public class Problem25 {

    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head.next;
            ListNode slow = head;
            while( fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    return true;
                }
            }
            return false;
        }
    }
}
