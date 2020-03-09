package channel.leetcode.questions.SwapNodesInPairs;

public class BestSolution {
    //This method is not constant space, the space is (n) bc it uses recursive stack
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    //
    public ListNode swapPairs2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(12);
        dummy.next = head;
        ListNode slow = head, fast = head.next, prev = dummy;

        while (fast != null ) {
            slow.next = fast.next;
            fast.next = slow;
            prev.next = fast;
            prev = slow;
            slow = slow.next;
            if(slow != null) {
                fast = slow.next;
            } else {
                break;
            }
        }

        return dummy.next;
    }
}
