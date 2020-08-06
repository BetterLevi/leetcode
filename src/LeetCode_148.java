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
}
