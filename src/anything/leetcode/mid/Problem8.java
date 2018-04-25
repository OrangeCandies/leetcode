package anything.leetcode.mid;

import linkedList.ListNode;

public class Problem8 {
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode current = head;
            ListNode odd = new ListNode(-1);
            ListNode p1 = odd;
            ListNode pd = new ListNode(-1);
            ListNode p2 = pd;
            while (current != null){
                p1.next = current;
                p1 = p1.next;
                p2.next = current.next;
                p2 = p2.next;
                current = current.next;
                if(current != null){
                    current = current.next;
                }
            }
            p1.next = pd.next;
            return odd.next;
        }
    }

}
