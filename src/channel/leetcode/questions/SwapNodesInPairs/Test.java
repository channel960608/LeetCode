package channel.leetcode.questions.SwapNodesInPairs;

import channel.leetcode.questions.TwoSum.BestSolution;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(0);
//        ListNode p1 = new ListNode(1);
//        ListNode p2 = new ListNode(2);
//        ListNode p3 = new ListNode(3);
//        ListNode p4 = new ListNode(4);
//        ListNode p5 = new ListNode(5);
//        head.next = p1;
//        p1.next = p2;
//        p2.next = p3;
//        p3.next = p4;
//        p4.next = p5;




        for(int i=1; i < 5; i++) {
            ListNode p = head;
            while(p.next != null)
                p = p.next;
            p.next = new ListNode(i);
        }

        solution.print(head);
        System.out.println();
        solution.print(solution.swapPairs(head));
    }
}
