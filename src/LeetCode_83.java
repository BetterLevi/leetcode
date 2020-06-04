import java.util.Arrays;

/**
 * @author Levi
 * @date 2020.6.3
 */
public class LeetCode_83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        while(head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }

}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}