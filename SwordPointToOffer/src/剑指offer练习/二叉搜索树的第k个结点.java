package 剑指offer练习;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，
 * 按结点数值大小顺序第三小结点的值为4。
 *
 * @author tankInternshipInterview
 * @create 2019/07/21 11:10
 */
public class 二叉搜索树的第k个结点 {
    public static void main(String[] args) {
        /**
         *        root1
         *          4
         *        2   6
         *      1  3 5 7
         */
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println(new 二叉搜索树的第k个结点().KthNode(root1, 0).value);
    }

    private TreeNode res;
    private int cnt;
    TreeNode KthNode(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        inOrder(root, k);
        return res;
    }

    private void inOrder(TreeNode root, int k) {

        if(root == null || cnt >= k)
            return;
        inOrder(root.left, k);
        cnt++;
        if (cnt == k) {
            res = root;
        }
        inOrder(root.right, k);
    }


    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        TreeNode(int value) {
            this.value = value;
        }
    }
}
