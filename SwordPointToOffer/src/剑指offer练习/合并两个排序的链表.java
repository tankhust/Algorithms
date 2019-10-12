package 剑指offer练习;

/**
 * @author tankInternshipInterview
 * @create 2019/07/11 00:31
 */
public class 合并两个排序的链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(7);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(8);
        ListNode res = new 合并两个排序的链表().mergeTwoSortedLinkedList(l1, l2);
        while (res != null) {
            System.out.print(res.value + "->");
            res = res.next;
        }
        System.out.println("null");
    }

    private ListNode mergeTwoSortedLinkedList(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode head = newList;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null) {
            head.next = l2;
        } else {
            head.next = l1;
        }
        return newList.next;
    }

    static class ListNode {
        ListNode next = null;
        int value;

        ListNode(int value) {
            this.value = value;
        }
    }
}
