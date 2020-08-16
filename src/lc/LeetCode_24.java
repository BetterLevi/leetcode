package lc;

/**
 * 两两交换链表中的结点
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author Levi
 * @date 2020.7.3
 */
public class LeetCode_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t = head;
        int flag = 0;
        while (t.next != null) {
            if (flag % 2 == 0) {
                int tmp = t.val;
                t.val = t.next.val;
                t.next.val = tmp;
            }
            flag++;
            t = t.next;
        }
        return head;
    }

    public ListNode swapPairs_bet(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs_bet(next.next);
        next.next = head;
        return next;
    }
}
