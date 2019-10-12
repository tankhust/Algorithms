package 牛油面试手撕;

/**
 * @author tankInternshipInterview
 * @create 2019/09/07 15:19
 */
public class 链表插入排序 {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        ListNode head = new ListNode(6);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        dummy.next = head;
        ListNode node = sort(dummy);
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }

    public static ListNode sort(ListNode node) {
        ListNode p, pre, q;
        p = node.next;
        node.next = null;//把链表分成两个区域，有序区和无序区，有序区默认为一个节点
        while (p != null) {
            q = p.next;// q存无序链表的下一个节点
            pre = node;
            while (pre.next != null && pre.next.val < p.val) {
                pre = pre.next;
            }
            p.next = pre.next;
            pre.next = p;
            p = q;
        }
        return node.next;
    }
    static class ListNode{
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }
}

