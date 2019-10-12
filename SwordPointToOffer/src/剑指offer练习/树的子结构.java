package 剑指offer练习;

/**
 * @author tankInternshipInterview
 * @create 2019/07/11 23:56
 */
public class 树的子结构 {
    public static void main(String[] args) {
        /**
         *      root1          root2
         *        1              2
         *      2   3         4    5
         *    4  5 6  7
         */
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(6);

        /**
         *      root3          root4
         *        8              8
         *      8   7         9    3
         *    9  3
         *      4 7
         */
        TreeNode root3 = new TreeNode(8);
        root3.left = new TreeNode(8);
        root3.right = new TreeNode(7);
        root3.left.left = new TreeNode(9);
        root3.left.right = new TreeNode(3);
        root3.left.right.left = new TreeNode(4);
        root3.left.right.right = new TreeNode(7);

        TreeNode root4 = new TreeNode(8);
        root4.left = new TreeNode(9);
        root4.right = new TreeNode(2);

        System.out.println(new 树的子结构().isSubTree(root1, root2));
        System.out.println(new 树的子结构().isSubTree(root3, root4));
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return hasSubTree(root1, root2) || isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    private boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.value != root2.value)
            return false;
        return hasSubTree(root1.left, root2.left) && hasSubTree(root1.right, root2.right);
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
