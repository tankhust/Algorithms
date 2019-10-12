package 秋招公司笔试20190727_20190921.zoom20190817;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/08/17 14:50
 */
public class 反序列化二叉树并判断是否是平衡二叉树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String[] split = next.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            queue.add(split[i]);
        }
        Node head = createTreeByPreOrder(queue);
        if (isBST(head)) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    private static Node createTreeByPreOrder(Queue < String > queue){
        String value = queue.poll();
        if (value.isEmpty()) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = createTreeByPreOrder(queue);
        head.right = createTreeByPreOrder(queue);
        return head;
    }

    private static boolean isBST(Node node) {
        if (node == null) {
            return true;
        }
        int right = binaryTreeHigh(node.right);
        int left = binaryTreeHigh(node.left);
        int gap = right - left;
        if (gap > 1 || gap < -1) {
            return false;
        }
        return isBST(node.left) && isBST(node.right);
    }

    private static int binaryTreeHigh(Node node) {
        if (node == null) {
            return 0;
        }
        int ret1 = binaryTreeHigh(node.left);
        int ret2 = binaryTreeHigh(node.right);
        return ret1 > ret2 ? ret1 + 1 : ret2 + 1;
    }
    static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }
}
