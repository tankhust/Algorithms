package 春招公司笔试20190310_20190515.携程4_8;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/04/08 19:46
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(s == null || s.length() == 0)
            System.out.println(false);
        else {
            char[] chs = new char[s.length() / 2 + 1];
            for (int i = 0; i < chs.length; i++) {
                chs[i] = s.charAt(2 * i);
            }
            boolean hasCircle = false;
            ListNode head = new ListNode(chs[0]);
            ListNode cur = head;
            for (int i = 1; i < chs.length; i++) {
                cur.next = new ListNode(chs[i]);
                cur = cur.next;
            }
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow.val == fast.val) {
                    hasCircle = true;
                    break;
                }
            }
            if(hasCircle)
                System.out.println(true);
            else
                System.out.println(false);
        }
    }
}
class ListNode{
    char val;
    ListNode next;
    public ListNode(char val){
        this.val = val;
        this.next = null;
    }
}