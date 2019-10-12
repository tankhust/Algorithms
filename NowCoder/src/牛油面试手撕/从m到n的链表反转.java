package 牛油面试手撕;

/**
 * @author tankInternshipInterview
 * @create 2019/07/25 07:45
 */
public class 从m到n的链表反转 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        ListNode listNode = new 从m到n的链表反转().reverseBetween(head, 2, 4);
        while (listNode != null) {
            System.out.print(listNode.value + "->");
            listNode = listNode.next;
        }
        System.out.println("null");
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;
        // 1 -> 2 -> 3 -> 4 -> 5 -> null  pre = 1; start = 2; then = 3; m = 2, n = 4;
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
            // 一次循环后 1 -> 3 -> 2 -> 4 -> 5 -> null
            // 二次循环后 1 -> 4 -> 3 -> 2 -> 5 -> null
        }
        return dummy.next;
    }

    static class ListNode {
        ListNode next = null;
        int value;

        ListNode(int value) {
            this.value = value;
        }
    }
}
