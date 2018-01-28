package linkedList;

public class SortList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        System.out.println(new SortList().sortList(listNode));
    }
    public ListNode sortList(ListNode head) {
        ListNode fast = null;
        ListNode slow = null;

        if (head == null || head.next == null) {
            return head;
        }
        fast = head.next;
        slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        return mergcSort(left,right);

    }

    private ListNode mergcSort(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode p = ans;

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                    p.next = l1;
                    p = p.next;
                    l1 = l1.next;
            } else {
                    p.next = l2;
                    p = p.next;
                    l2 = l2.next;
            }
        }
        if(l1 == null){
            p.next = l2;
        }
        if(l2 == null){
            p.next = l1;
        }
        return ans.next;
    }
}
