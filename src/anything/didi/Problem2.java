package anything.didi;

public class Problem2 {

    static class Node{
        public int data;
        public Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node getAnswer(Node l1, Node l2){

       l1 = reserver(l1);
       l2 = reserver(l2);


       Node answer = new Node(-1);
       Node current = answer;
       Node p1 = l1;
       Node p2 = l2;
       int flag = 0;
       while ( p1 != null ){
           if(p2 == null){
              if(flag == -1){
                  p1.data = p1.data -1;
                  current.next = p1;
                  p1 = p1.next;
                  continue;
              }
           }
           if(p1.data + flag > p2.data){
               current.next = new Node(p1.data-p2.data);
               p1 = p1.next;
               p2 = p2.next;
               current = current.next;
               flag = 0;
           }else{
               current.next = new Node(p1.data+flag+10-p2.data);
               current = current.next;
               p1 = p1.next;
               p2 = p2.next;
               flag = -1;
           }

       }

       return reserver(answer.next);
    }

    public static Node reserver(Node l1){
        Node newHead = null;
        Node next = l1;
        Node current = l1;
        while(current != null){
            next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }
        return newHead;
    }

    public static void printNode(Node node1){
        while(node1 != null){
            System.out.println(node1.data);
            node1 = node1.next;
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(5);

        Node node2 = new Node(9);
        node2.next = new Node(9);

        node1  = getAnswer(node1,node2);

        printNode(node1);



    }
}
