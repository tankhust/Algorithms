package 春招公司笔试20190310_20190515.basicClass;

import java.util.LinkedList;
import java.util.Queue;

public class Code_23_isBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value=data;
        }
    }
    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        boolean isLeaf=false;
        Node l = null;
        Node r = null;
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (l == null && r != null) {
                return false;
            }
            if (isLeaf && (l != null || r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                isLeaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        System.out.println(isBST(head));
    }


}
