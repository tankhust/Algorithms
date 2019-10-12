package 剑指offer练习;


import java.util.ArrayList;

/**
 * @author tankInternshipInterview
 * @create 2019/08/14 07:20
 */
public class 二叉树中和为某一值的路径2 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int k) {
        backTracking(root, k, new ArrayList<>());
        return res;
    }
    public void backTracking(TreeNode node, int target, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
        }else{
            backTracking(node.left,target,list);
            backTracking(node.right,target,list);
        }
        res.remove(res.size() - 1);
    }
}
