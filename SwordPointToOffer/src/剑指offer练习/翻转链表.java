package 剑指offer练习;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @author tankInternshipInterview
 * @create 2019/07/11 00:21
 */
public class 翻转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next= new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        ListNode res = new 翻转链表().revertList(head);
        while(res != null){
            System.out.print(res.value + "->");
            res = res.next;
        }
        System.out.println("null");
    }
    public ListNode revertList(ListNode listNode) {
        if(listNode == null)
            return listNode;
        ListNode newList = new ListNode(-1);
        while (listNode != null) {
            ListNode next = listNode.next;
            listNode.next = newList.next;
            newList.next = listNode;
            listNode = next;
        }
        return newList.next;
    }
    static class ListNode{
        ListNode next = null;
        int value;
        public ListNode(int value){
            this.value = value;
        }
    }
}
