package 剑指offer练习;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *  从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @author tankInternshipInterview
 * @create 2019/07/21 10:44
 */
public class 把二叉树打印成多行 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> res = new 把二叉树打印成多行().print(root1);
        for (ArrayList<Integer> list : res) {
            for (int temp : list) {
                System.out.print(temp + " ");
            }
            System.out.println();
        }
    }
    ArrayList<ArrayList<Integer>> print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list =new ArrayList<>();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    queue.add(temp.left);
                    queue.add(temp.right);
                    list.add(temp.val);
                }
            }
            if (!list.isEmpty()) {
                res.add(list);
            }
        }
        return res;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
