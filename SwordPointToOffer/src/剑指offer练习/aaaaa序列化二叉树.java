package 剑指offer练习;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * @author tankInternshipInterview
 * @create 2019/07/21 11:08
 */
public class aaaaa序列化二叉树 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
    }
    String Serialize(TreeNode root) {
        return "";
    }
    TreeNode Deserialize(String str) {
        return new TreeNode(1);
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
