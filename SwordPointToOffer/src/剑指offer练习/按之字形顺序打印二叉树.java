package 剑指offer练习;

import java.util.*;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author tankInternshipInterview
 * @create 2019/07/21 10:21
 */
public class 按之字形顺序打印二叉树 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> res = new 按之字形顺序打印二叉树().print(root1);
        for (ArrayList<Integer> list : res) {
            for (int temp : list) {
                System.out.print(temp + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    queue.add(temp.left);
                    queue.add(temp.right);
                    list.add(temp.val);
                }
            }
            if (reverse) {
                Collections.reverse(list);
            }
            reverse = !reverse;
            res.add(list);
        }
        return res;
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
