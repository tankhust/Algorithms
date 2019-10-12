package 剑指offer练习;

/**
 * @author tankInternshipInterview
 * @create 2019/07/11 00:09
 */
public class 链表中倒数第k个节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next= new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        System.out.println(new 链表中倒数第k个节点().findKthNodeToTail(head,3).value);
    }

    public ListNode findKthNodeToTail(ListNode node, int k) {
        if (node == null)
            return node;
        ListNode fast = node;
        ListNode slow = node;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    static class ListNode {
        ListNode next = null;
        int value;

        ListNode(int value) {
            this.value = value;
        }
    }
}
