package anything;

/**
 * 反转链表
 */
public class Offer16 {

    static class LinkNode{
        int data;
        LinkNode next;
        LinkNode(int data){
            this.data = data;
            next = null;
        }
    }

    public static LinkNode reveserList(LinkNode head){
//        if(head == null){
//            return null;
//        }
//        LinkNode newHead = null;
//        LinkNode nextNode = head;
//        LinkNode currentNode = null;
//        while(nextNode != null){
//            currentNode = nextNode;
//            nextNode = nextNode.next;
//            currentNode.next = newHead;
//            newHead = currentNode;
//
//        }
//        return newHead;
/*        if(head == null){
            return null;
        }
        LinkNode cur = null;
        LinkNode next = head;
        LinkNode newHead = null;
        while (next != null){
            cur = next;
            next = next.next;
            cur.next = newHead;
            newHead = cur;
        }
        return newHead;
  */
        if(head == null){
            return null;
        }
        LinkNode newHead = null;
        LinkNode next = head.next;
        while(head != null){
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkNode head = new LinkNode(1);
        LinkNode p1 = new LinkNode(2);
        LinkNode p2 = new LinkNode(3);
        LinkNode p3 = new LinkNode(4);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;

        LinkNode ans =reveserList(head);
        while (ans != null){
            System.out.println(ans.data);
            ans = ans.next;
        }
    }
}
