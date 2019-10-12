package 剑指offer练习;

/**
 * @author tankInternshipInterview
 * @create 2019/07/17 08:26
 */
public class 平衡二叉树 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println(new 平衡二叉树().isBalancedTree(root1));
    }
    private boolean isBalancedTree(TreeNode root){
        if(root == null)
            return false;
        return isBalancedTreeCore(root) != -1;
    }
    private int isBalancedTreeCore(TreeNode root){
        if(root == null)
            return 0;
        int left = isBalancedTreeCore(root.left);
        if(left == -1)
            return -1;
        int right = isBalancedTreeCore(root.right);
        if(right == -1)
            return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left,right) + 1;
    }
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }
}
