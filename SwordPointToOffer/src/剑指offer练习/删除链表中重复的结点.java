package 剑指offer练习;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author tankInternshipInterview
 * @create 2019/07/21 09:21
 */
public class 删除链表中重复的结点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next= new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode listNode = new 删除链表中重复的结点().findDuplication(head);
        while (listNode != null) {
            System.out.print(listNode.value + "->");
            listNode = listNode.next;
        }
        System.out.println("null");
    }

    private ListNode findDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        if (head.value == next.value) {
            return findDuplication(next.next);
        }else{
            head.next = findDuplication(head.next);
            return head;
        }
    }
    static class ListNode {
        ListNode next = null;
        int value;

        ListNode(int value) {
            this.value = value;
        }
    }
}
