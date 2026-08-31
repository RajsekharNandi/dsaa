/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstIdx = -1;
        int prevIdx = -1;
        int idx = 1;

        ListNode prevNode = head;
        ListNode node = head.next;

        int minDist = Integer.MAX_VALUE;
        int maxDist = -1;

        while (node != null && node.next != null) {
            boolean isMax = node.val > prevNode.val && node.val > node.next.val;
            boolean isMin = node.val < prevNode.val && node.val < node.next.val;

            if (isMax || isMin) {
                if (firstIdx == -1) {
                    firstIdx = idx;
                } else {
                    minDist = Math.min(minDist, idx - prevIdx);
                    maxDist = idx - firstIdx;
                }
                prevIdx = idx;
            }

            prevNode = node;
            node = node.next;
            idx++;
        }

        if (maxDist == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{minDist, maxDist};
    }
}