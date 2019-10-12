package 剑指offer练习;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @author tankInternshipInterview
 * @create 2019/07/21 08:57
 */
public class 链表中环的入口节点 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        ListNode node1 = new ListNode(3);
        root.next.next = node1;
        ListNode node2 = new ListNode(4);
        root.next.next.next = node2;
        ListNode node3 = new ListNode(5);
        root.next.next.next.next = node3;
        ListNode node4 = new ListNode(6);
        root.next.next.next.next.next = node4;
        root.next.next.next.next.next.next = node1;

        System.out.println(new 链表中环的入口节点().findEntryOfLoop(root).val);
    }

    public ListNode findEntryOfLoop(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode fast = root;
        ListNode slow = root;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = root;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    static class ListNode{
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }
}
