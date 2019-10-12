package 牛油面试手撕;

/**
 * @author tankInternshipInterview
 * @create 2019/08/28 16:30
 */
public class 判断是否是二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println(new 判断是否是二叉搜索树().isBST(root1));
    }

    static TreeNode pre = null;
    public static boolean isBST(TreeNode node) {
        if (node != null) {
            if (!isBST(node.left)) {
                return false;
            }
            if (pre != null && pre.val > node.val) {
                return false;
            }
            pre = node;
            if (!isBST(node.right)) {
                return false;
            }
        }
        return true;
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

