package 牛油面试手撕;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tankInternshipInterview
 * @create 2019/07/27 11:58
 */
public class 二叉树非递归中序 {
    public static void main(String[] args) {
        /**
         *        root1
         *          4
         *       2     6
         *     1  3  5  7
         */
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println(new 二叉树非递归中序().iterInOrder(root1, new ArrayList<>()));

    }

    private List<Integer> iterInOrder(TreeNode node, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
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
