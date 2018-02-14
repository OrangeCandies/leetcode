package anything;

public class Offer15 {

    static class LinkNode{
        int data;
        LinkNode next;
    }

    public static LinkNode FindKthToTail(LinkNode pheand,int K){
        if(pheand == null || K == 0){
            return null;
        }
        LinkNode fast = pheand;
        LinkNode slow = pheand;

        for(int i=0; i<K-1;i++){
            if(fast.next != null){
                fast = fast.next;
            }else {
                return null;
            }
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}


