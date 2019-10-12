package 剑指offer练习;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tankInternshipInterview
 * @create 2019/07/13 19:23
 */
public class 从上往下打印二叉树 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        System.out.println(new 从上往下打印二叉树().PrintFromTopToBottom(root1));
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                continue;
            }
            res.add(temp.val);
            queue.add(temp.left);
            queue.add(temp.right);
        }
        return res;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
