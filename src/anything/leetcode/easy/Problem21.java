package anything.leetcode.easy;

import linkedList.ListNode;

public class Problem21 {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (n-- >= 0) {
                if(fast != null)
                    fast = fast.next;
                else
                    return null;
            }
            if(fast == null)
                return head.next;
            while(fast.next != null){
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }


}
