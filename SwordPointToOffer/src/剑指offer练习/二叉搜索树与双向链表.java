package 剑指offer练习;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author tankInternshipInterview
 * @create 2019/07/14 11:31
 */
public class 二叉搜索树与双向链表 {
    private static TreeNode pre = null;
    private static TreeNode head = null;
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        new 二叉搜索树与双向链表().Convert(root1);
        while(head != null){
            System.out.print(head.val + "->");
            head = head.right;
        }
        System.out.println("null");
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }
    private void inOrder(TreeNode node){
        if(node == null)
            return;
        inOrder(node.left);
        node.left = pre;
        if(pre != null){
            pre.right = node;
        }
        pre = node;// node 赋给pre以便下一次循环
        if(head == null){
            head = node;// 取中序遍历第一个node为head
        }
        inOrder(node.right);
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
