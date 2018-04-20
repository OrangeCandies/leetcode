package anything.leetcode.mid;

import linkedList.ListNode;

public class Problem8 {
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head == null){
                return null;
            }
            boolean flag = false;
            if(head.val % 2 == 0){
                flag = true;
            }
            ListNode current = head;
            ListNode odd = new ListNode(-1);
            ListNode p1 = odd  ;
            ListNode and = new ListNode(-1);
            ListNode p2 = and;
            while(current != null){
                if(current.val %2 == 0){
                    p2.next = current;
                    p2 = p2.next;
                }else {
                    p1.next = current;
                    p1 = p1.next;
                }
                current = current.next;
            }
            p1.next = null;
            p2.next = null;
            if(true){
                p2.next = odd.next;
                return and.next;
            }else{
                p1.next = and.next;
                return odd.next;
            }

        }
    }

}
