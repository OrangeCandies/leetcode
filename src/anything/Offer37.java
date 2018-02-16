package anything;

public class Offer37 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int value) {
            val = value;
            next = null;
        }
    }

    public static ListNode firstSomeNode(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode lang = null;
        ListNode shrt = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        int count = 0;
        if (p2 == null) {
            lang = l1;
            shrt = l2;
            while (p1 != null) {
                p1 = p1.next;
                count++;
            }
        } else if (p1 == null) {
            lang = l2;
            shrt = l1;
            while (p2 != null) {
                p2 = p2.next;
                count++;
            }
        }
        while (count-- > 0) {
            lang = lang.next;
        }
        while (lang != null && shrt != null){
            if(lang.val == shrt.val){
                return lang;
            }
            lang = lang.next;
            shrt = shrt.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(3);
        System.out.println(firstSomeNode(l1,l2).val);
    }

}
