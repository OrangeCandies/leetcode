package anything.leetcode.mid;

import linkedList.ListNode;

public class Problem7 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode ans = new ListNode(0);
            ListNode head = ans;
            int flag = 0;
            while(p1 != null && p2 != null) {
                ans.next = new ListNode((flag + p1.val + p2.val) % 10);
                ans = ans.next;
                flag = (p1.val+p2.val)/10;
                p1 = p1.next;
                p2 = p2.next;
            }
            if(p1 != null){
                while ( p1.next != null ){
                    p1.val = (p1.val+flag) %10;
                    flag = (p1.val + flag) /10;
                    p1 = p1.next;
                }
                if(flag != 0){
                    p1.next = new ListNode(flag);
                }
            }else {
                while ( p2.next != null ){
                    p2.val = (p2.val+flag) %10;
                    flag = (p2.val + flag) /10;
                    p2 = p2.next;
                }
                if(flag != 0){
                    p2.next = new ListNode(flag);
                }
            }
            return head.next;
        }
    }



}
