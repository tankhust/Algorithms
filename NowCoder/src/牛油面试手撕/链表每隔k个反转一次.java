package 牛油面试手撕;

import javax.xml.soap.Node;

/**
 * @author tankInternshipInterview
 * @create 2019/08/20 15:06
 */
public class 链表每隔k个反转一次 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        ListNode res = reverseKGroup(head, 3);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("null");
    }

    private static ListNode reverseKGroup(ListNode head,int k) {
        if (head == null || k <= 1) {
            return head;
        }
        int n = listLen(head);

        ListNode header = new ListNode(-1);
        header.next = head;

        ListNode cur = header;
        while (n >= k) {
            ListNode next = cur.next;
            cur.next = kReverse(next,k);
            cur = next;
            n -= k;
        }
        return header.next;
    }

    private static ListNode kReverse(ListNode node, int k) {
        ListNode pre = null;
        ListNode cur = node;
        while (k-- > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        /**
         * 逆序后，pre变成第一个节点，node变成最后一个节点，
         * 此时需要改动head的next指向逆序钱的第k+1个节点
         * 而这个节点刚好是cur
         */
        node.next = cur;
        return pre;
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
