package channel.leetcode.questions.AddTwoNumbers;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node0 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);

        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(5);

        node0.next = node1;
        node1.next = node2;
        node3.next = node4;
        node4.next = node5;

      solution.addTwoNumbers(node6, node7);
    }
}
