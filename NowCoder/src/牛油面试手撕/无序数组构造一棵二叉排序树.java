package 牛油面试手撕;

/**
 * @author tankInternshipInterview
 * @create 2019/09/01 09:41
 */
public class 无序数组构造一棵二叉排序树 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 1, 3,5,7};
        TreeNode node = null;
        node = new 无序数组构造一棵二叉排序树().createBST(node,arr);
        System.out.println(node.left.left.val);
        System.out.println(node.left.val);
        System.out.println(node.left.right.val);
        System.out.println(node.val);
        System.out.println(node.right.left.val);
        System.out.println(node.right.val);
        System.out.println(node.right.right.val);
    }

    private TreeNode createBST(TreeNode node, int[] arr) {
        if (arr == null || arr.length == 0) {
            return node;
        }
        for (int i = 0; i < arr.length; i++) {
            node = build(node, arr[i]);
        }
        return node;
    }

    private TreeNode build(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
            return node;
        } else {
            if (val < node.val) {
                node.left = build(node.left, val);
            } else {
                node.right = build(node.right, val);
            }
            return node;
        }
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

