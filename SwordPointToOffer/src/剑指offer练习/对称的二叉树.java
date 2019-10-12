package 剑指offer练习;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author tankInternshipInterview
 * @create 2019/07/21 10:02
 */
public class 对称的二叉树 {
    public static void main(String[] args) {
         /**
         *      root1
         *        1
         *      2   2
         *    3  4 4  3
         */
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        System.out.println(new 对称的二叉树().isSymmetrical(root1));
    }

    public boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetricalCore(root.left,root.right);
    }

    private boolean isSymmetricalCore(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        return isSymmetricalCore(node1.left, node2.right) && isSymmetricalCore(node1.right,node2.left);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val = 0;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
