package lc;

/**
 * reverse list
 * @author Levi
 * @date 2020.8.12
 */
public class LeetCode_206 {
    public ListNode reverseList_iterative(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseList_recursive(ListNode head) {
        return helper(head, null);
    }

    private ListNode helper(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return helper(next, head);
    }
}
