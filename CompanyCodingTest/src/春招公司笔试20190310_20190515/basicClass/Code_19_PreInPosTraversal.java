package 春招公司笔试20190310_20190515.basicClass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Code_19_PreInPosTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value=data;
        }
    }

    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value+" ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value+" ");
    }

    public static List<Integer> preOrderTraversal(Node head) {
        List<Integer> result = new ArrayList<>();
        Deque<Guide> path = new ArrayDeque<>();
        path.addFirst(new Guide(0,head));

        while (!path.isEmpty()) {
            Guide current=path.removeFirst();
            if (current.node == null) {
                continue;
            }

            if (current.ope == 1) {
                result.add(current.node.value);
            } else {
                path.addFirst(new Guide(0,current.node.right));
                path.addFirst(new Guide(0,current.node.left));
                path.addFirst(new Guide(1,current.node));
            }
        }
        return result;
    }
    public static List<Integer> inOrderTraversal(Node head) {
        List<Integer> result = new ArrayList<>();
        Deque<Guide> path = new ArrayDeque<>();
        path.addFirst(new Guide(0,head));

        while (!path.isEmpty()) {
            Guide current=path.removeFirst();
            if (current.node == null) {
                continue;
            }

            if (current.ope == 1) {
                result.add(current.node.value);
            } else {
                path.addFirst(new Guide(0,current.node.right));
                path.addFirst(new Guide(1,current.node));
                path.addFirst(new Guide(0,current.node.left));
            }
        }
        return result;
    }
    public static List<Integer> posOrderTraversal(Node head) {
        List<Integer> result = new ArrayList<>();
        Deque<Guide> path = new ArrayDeque<>();
        path.addFirst(new Guide(0,head));

        while (!path.isEmpty()) {
            Guide current=path.removeFirst();
            if (current.node == null) {
                continue;
            }

            if (current.ope == 1) {
                result.add(current.node.value);
            } else {
                path.addFirst(new Guide(1,current.node));
                path.addFirst(new Guide(0,current.node.right));
                path.addFirst(new Guide(0,current.node.left));
            }
        }
        return result;
    }

    public static class Guide {
        int ope;//0:visit,1:print
        Node node;

        public Guide(int ope,Node node) {
            this.ope = ope;
            this.node = node;
        }
    }


    public static void main(String[] args) {
        Node head=new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        //recursive
        System.out.println("===============recursive==============");
        System.out.println("preOrderRecur:");
        preOrderRecur(head);
        System.out.println();
        System.out.println("inOrderRecur:");
        inOrderRecur(head);
        System.out.println();
        System.out.println("posOrderRecur:");
        posOrderRecur(head);
        System.out.println();

        System.out.println("===============================");
        System.out.println("preOrderTraversal:");
        List<Integer> list=preOrderTraversal(head);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println();

        System.out.println("inOrderTraversal:");
        list=inOrderTraversal(head);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println();

        System.out.println("posOrderTraversal:");
        list=posOrderTraversal(head);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println();


    }
}
