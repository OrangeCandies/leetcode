package anything.leetcode.easy;

import linkedList.ListNode;

public class Problem23 {

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode p = l1;
            ListNode q = l2;
            ListNode ans = new ListNode(1);
            ListNode cur = ans;
            while ( q != null && p != null){
                if(q.val  < p.val){
                    cur.next = q;
                    q = q.next;
                    cur = cur.next;
                }else{
                    cur.next = p;
                    p = p.next;
                    cur = cur.next;
                }
            }

            if(q == null){
                cur.next = p;
            }else{
                cur.next = q;
            }
            return ans.next;
        }
    }
}
