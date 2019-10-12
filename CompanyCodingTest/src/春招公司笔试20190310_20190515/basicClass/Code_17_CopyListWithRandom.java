package 春招公司笔试20190310_20190515.basicClass;

import java.util.HashMap;

public class Code_17_CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node random;

        public Node(int data) {
            this.value=data;
        }
    }

    public static Node copyListWithRandom1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node tmp=head;
        while (tmp != null) {
            map.put(tmp, new Node(tmp.value));
            tmp=tmp.next;
        }
        tmp=head;
        while (tmp != null) {
            map.get(tmp).next=map.get(tmp.next);
            map.get(tmp).random = map.get(tmp.random);
            tmp = tmp.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRandom2(Node head) {
        Node curr=head;
        Node tmp=null;
        while (curr != null) {
            tmp = curr.next;
            curr.next = new Node(curr.value);
            curr.next.next=tmp;
            curr = tmp;
        }//将每个节点复制的节点接在对应节点后
        curr=head;
        while (curr != null) {
            curr.next.random = curr.random!=null?curr.random.next:null;
            curr = curr.next.next;
        }//将复制的节点的random指针指向对应的random节点
        curr = head;
        Node res = null;
        while (curr != null) {
            tmp = curr.next.next;
            res = curr.next;
            curr.next=tmp;
            res.next = tmp != null ? tmp.next : null;
            curr=tmp;
        }
        return res;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.random == null ? "- " : cur.random.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRandom1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRandom2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRandom1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRandom2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
