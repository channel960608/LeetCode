package channel.leetcode.questions.SwapNodesInPairs;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
        for(ListNode n = h; n.next != null && n.next.next != null; n = n.next.next) {
            swap(n);
        }
        return h.next;
    }

    void swap(ListNode node) {
        ListNode n = node.next;
        node.next = n.next;
        n.next = n.next.next;
        node.next.next = n;
    }


    void print(ListNode head) {
        for(ListNode n = head; n != null; n = n.next) {
            System.out.println(n.val);
        }
    }
}