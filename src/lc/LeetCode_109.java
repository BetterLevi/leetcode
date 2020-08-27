package lc;

/**
 * @author Levi
 * @date 2020.8.18
 */
public class LeetCode_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        if (head.next.next == null) {
            TreeNode root = new TreeNode(head.val);
            if (head.val > head.next.val) {
                root.left = new TreeNode(head.next.val);
            } else {
                root.right = new TreeNode(head.next.val);
            }
            return root;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if ((fast = fast.next) != null) {
                fast = fast.next;
            } else {
                break;
            }
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next == slow) {
                tmp.next = null;
                break;
            }
            tmp = tmp.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }


    public TreeNode sortedListToBST_bet(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;

        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        thead.right = toBST(slow.next,tail);
        return thead;
    }
}
