package 秋招公司笔试20190727_20190921.欢聚时代20190909;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/09 19:03
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums = (int)Math.pow(2, n) - 1;
        TreeNode root = new TreeNode(sc.nextInt());
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.add(root);
        while (--nums > 0) {
            queue1.add(sc.nextInt());
        }
        while (!queue1.isEmpty()) {
            int size = queue2.size();
            while (size-- > 0) {
                TreeNode node = queue2.poll();
                node.left = new TreeNode(queue1.poll());
                node.right = new TreeNode(queue1.poll());
                queue2.add(node.left);
                queue2.add(node.right);
            }
        }
        inOrder(root);
    }

    private static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.val);
            inOrder(node.right);
        }
    }

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
