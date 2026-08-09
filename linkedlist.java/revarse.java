public class revarse {


    public Node reverseRecursive(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node newHead = reversRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        revarse list = new revarse();
        list.pritnList();
       list.head = list.reverseIterate(list.head);
        list.printList();  
    }
}
