package anything.leetcode.mid;

import linkedList.ListNode;

import java.util.Stack;

public class Problem9 {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null){
                return null;
            }
            Stack<ListNode> stack1 = new Stack<>();
            Stack<ListNode> stack2 = new Stack<>();
            ListNode current1 = headA;
            ListNode current2 = headB;
            while(current1 != null){
                stack1.push(current1);
                current1 = current1.next;
            }
            while(current2 != null){
                stack2.push(current2);
                current2 = current2.next;
            }
            ListNode ans = null;
            while(stack1.size()!= 0 && stack2.size() != 0){
                if(stack1.peek() != stack2.peek()){
                    return ans;
                }
                ans = stack1.pop();
                stack2.pop();
            }
            return ans;
        }
    }


}
