package lc;

/**
 * 删除排序链表中的重复元素 II
 * @author wei.liang
 * @since 2021/3/25
 */
public class LeetCode_82 {
    //wrong ans
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode forward = head;
        while (forward.next != null) {
            if (forward.val != forward.next.val) {
                break;
            }
            forward = forward.next;
        }
        if (forward.next == null) {
            return null;
        }
        if (forward != head) {
            forward = forward.next;
        }
        ListNode next = forward.next;
        if (next == null) {
            return null;
        }
        while (next.next != null) {
            ListNode tmp = next.next;
            while (tmp.next != null && tmp.val == tmp.next.val) {
                tmp = tmp.next;
            }
            forward.next.next = tmp.next;
            if (tmp.next == null) {
                break;
            }
            next = tmp.next;
        }
        return forward;
    }
}
