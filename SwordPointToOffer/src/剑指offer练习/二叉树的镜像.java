package 剑指offer练习;

/**
 * @author tankInternshipInterview
 * @create 2019/07/12 00:36
 */
public class 二叉树的镜像 {
    public static void main(String[] args) {
        /**
         *      root1         镜像
         *        1              1
         *      2   3         3    2
         *    4  5 6  7     7  6  5 4
         */
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        new 二叉树的镜像().Mirror(root1);
        System.out.println(root1.value);
        System.out.print(root1.left.value + " ");
        System.out.println(root1.right.value);
        System.out.print(root1.left.left.value + " ");
        System.out.print(root1.left.right.value + " ");
        System.out.print(root1.right.left.value + " ");
        System.out.print(root1.right.right.value + " ");

    }
    private void Mirror(TreeNode root) {
        if(root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        Mirror(left);
        Mirror(right);

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
