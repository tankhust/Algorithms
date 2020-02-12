package LeetCode按题号排序;

/**
 * @author tank
 * @create 2020/02/12 16:42
 */
public class L2_M_Add_Two_Numbers {
    public static void main(String[] args) {
        L2_M_Add_Two_Numbers l2 = new L2_M_Add_Two_Numbers();
        //[0,8,6,5,6,8,3,5,7]
        //[6,7,8,0,8,5,8,9,7]
        int[] arr1 = {0,8,6,5,6,8,3,5,7};
        int[] arr2 = {6,7,8,0,8,5,8,9,7};
        ListNode l1 = new ListNode(-1);
        ListNode l1_pre = l1;
        ListNode l22 = new ListNode(-1);
        ListNode l22_pre = l22;
        for (int nextInt : arr1) {
            l1_pre.next = new ListNode(nextInt);
            l1_pre = l1_pre.next;
        }
        for (int nextInt : arr2) {
            l22_pre.next = new ListNode(nextInt);
            l22_pre = l22_pre.next;
        }
        ListNode result = l2.addTwoNumbers(l1.next, l22.next);

//        while (l1 != null) {
//            System.out.print(l1.val + "->");
//            l1 = l1.next;
//        }
//
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        int curr = 0;
        int c = 0;//进位
        int tempC  = 0;
        while(l1 != null || l2 != null || c != 0){
            curr = l1 == null ? (l2 == null ?  0 : l2.val) : (l2 == null ? l1.val : l1.val + l2.val);
            tempC = (curr + c) / 10;
            curr = (curr + c) % 10;
            c = tempC;
            pre.next = new ListNode(curr);
            pre = pre.next;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }

        return head.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ this.val = x;}
}
