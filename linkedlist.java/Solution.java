public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        int size = 0;
        ListNode curr = head;

        while (curr != null)  {
            curr = curr.next;
            size++;
        }

        if (n == size) {
            return head.next;
        }

        int indexToSearch = size - n;
        ListNode prev = head;

        for (int i = 0; i < indexToSearch - 1; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return head;
    }
}
