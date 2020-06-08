/**
 * remove N-th node from end of list
 *
 * @author Levi
 * @date 2020.6.8
 */
public class LeetCode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode t = head;
        while(t != null) {
            len++;
            t = t.next;
        }
        t = head;
        int p = 1;
        if(0 == len - n) {
            t = t.next;
            return t;
        }
        while(p != len - n) {
            t = t.next;
            p++;
        }
        if(t.next == null || t.next.next == null) {
            t.next = null;
            return head;
        }
        t.next = t.next.next;
        return head;
    }

    public ListNode removeNthFromEnd_better(ListNode head, int n) {
        ListNode s = head;
        ListNode e = head;
        while (n != 0) {
            n--;
            e = e.next;
        }
        if(e == null) {
            head = head.next;
            return head;
        }
        while (e.next != null) {
            s = s.next;
            e = e.next;
        }
        if (s.next == null || s.next.next == null) {
            s.next = null;
            return head;
        }
        s.next = s.next.next;
        return head;
    }
}
