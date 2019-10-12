package 剑指offer练习;

/**
 * @author tankInternshipInterview
 * @create 2019/07/17 08:18
 */
public class 二叉树的深度 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println(new 二叉树的深度().TreeDepth(root1));
    }

    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        return Math.max(TreeDepth(left), TreeDepth(right)) + 1;
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
