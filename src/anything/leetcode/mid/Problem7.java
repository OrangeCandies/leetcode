package anything.leetcode.mid;

import linkedList.ListNode;

public class Problem7 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ans = new ListNode(1);
            ListNode cur = ans;
            int flag = 0;
            while(l1 != null || l2 != null || flag != 0){
                int sum = (l1 != null ? l1.val : 0) +( l2 != null ? l2.val : 0 ) + flag;
                flag = sum/10;
                cur.next = new ListNode(sum%10);
                cur = cur.next;
                l1 = l1 == null ? l1 :  l1.next;
                l2 = l2 == null ? l2 : l2.next;

            }
            return ans.next;
        }
    }



}
