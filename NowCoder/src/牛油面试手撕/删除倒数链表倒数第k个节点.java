package 牛油面试手撕;

/**
 * @author tankInternshipInterview
 * @create 2019/08/21 15:31
 */
public class 删除倒数链表倒数第k个节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);


        int k = 3;
        RDelete(head, k);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    private static void RDelete(ListNode node, int k) {
        int len = listLen(node);
        if (len < k) {
            return;
        }
        ListNode slow = node;
        ListNode fast = node;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode nodeToDelete = slow.next;
        ListNode next = nodeToDelete.next;
        slow.next = next;
        nodeToDelete.next = null;
    }
    private static int listLen(ListNode node){
        int count = 1;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }
}
