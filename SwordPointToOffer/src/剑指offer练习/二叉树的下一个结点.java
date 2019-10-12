package 剑指offer练习;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author tankInternshipInterview
 * @create 2019/07/21 09:39
 */
public class 二叉树的下一个结点 {
    public static void main(String[] args) {
        /**
         *               1
         *          2         3
         *       4    5     6     7
         */
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);    root.left.next = root;
        root.right = new TreeLinkNode(3);   root.right.next = root;
        root.left.left = new TreeLinkNode(4);  root.left.left.next = root.left;
        root.left.right = new TreeLinkNode(5); root.left.right.next = root.left;
        root.right.left = new TreeLinkNode(6);  root.right.left.next = root.right;
        root.right.right = new TreeLinkNode(7); root.right.right.next = root.right;
        System.out.println(new 二叉树的下一个结点().GetNext(root.left).val);
        System.out.println(new 二叉树的下一个结点().GetNext(root.left.right).val);
    }

    private TreeLinkNode GetNext(TreeLinkNode root) {
        if (root == null) {
            return root;
        }
        if (root.right != null) {
            TreeLinkNode next = root.right;
            while (next.left != null) {
                next = next.left;
            }
            return next;
        }else{
            while (root.next != null) {
                TreeLinkNode parent = root.next;
                if (parent.left == root) {
                    return parent;
                }
                root = parent;
            }
        }
        return null;
    }
    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
