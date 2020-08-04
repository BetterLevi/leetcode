import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 排序链表
 *  O(n log n)
 * @author Levi
 * @date 2020.8.3
 */
public class LeetCode_148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> vals = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            vals.add(tmp.val);
            tmp = tmp.next;
        }
        vals.sort(Comparator.comparing(Integer::intValue));
        tmp = head;
        for (Integer val : vals) {
            tmp.val = val;
            tmp = tmp.next;
        }
        return head;
    }

    public static ListNode sortList_bet(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode init = head.next;
        ListNode point = head;
        while (init != null) {
            if (init.val < point.val) {
                int i = point.val;
                point.val = init.val;
                init.val = i;
            }
            ListNode tmp = point;
            while (tmp != null) {
                if (tmp.val < init.val && tmp.next.val > init.val) {
                    init.next = tmp.next;
                    tmp.next = init;
                    break;
                }
                if (tmp.next == null) {
                    tmp.next = init;
                    break;
                }
                tmp = tmp.next;
            }
            init = init.next;
        }
        return head;
    }
}
