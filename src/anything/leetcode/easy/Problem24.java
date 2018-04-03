package anything.leetcode.easy;

import linkedList.ListNode;

public class Problem24 {


    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null){
                return true;
            }
            ListNode fast = head.next;
            ListNode slow = head;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }

            ListNode tail = resverList(slow.next);
            slow.next = null;
            while(tail != null && head != null){
                if(tail.val != head.val){
                    return false;
                }
            }
            return true;
        }

        private ListNode resverList(ListNode p) {
            ListNode cur = p;
            ListNode head = null;
            ListNode next = null;
            while(cur != null){
                next = cur.next;
                cur.next = head;
                head = cur;
                cur = next;
            }
            return head;

        }
    }


}
