package channel.leetcode.questions.AddTwoNumbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode p = ans;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int sum = value1 + value2 + carry;
            carry = sum / 10;

            p.next = new ListNode(sum%10);
            p = p.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return ans.next;
    }
}