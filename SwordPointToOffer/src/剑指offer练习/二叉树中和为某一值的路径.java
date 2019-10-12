package 剑指offer练习;

import java.util.ArrayList;

/**
 *
 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * @author tankInternshipInterview
 * @create 2019/07/14 10:35
 */
public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        /**
         *      root1         镜像
         *        1              1
         *      2   6         3    2
         *    4  5 1  0     7  6  5 4
         */
        二叉树的镜像.TreeNode root1 = new 二叉树的镜像.TreeNode(1);
        root1.left = new 二叉树的镜像.TreeNode(2);
        root1.right = new 二叉树的镜像.TreeNode(6);
        root1.left.left = new 二叉树的镜像.TreeNode(4);
        root1.left.right = new 二叉树的镜像.TreeNode(5);
        root1.right.left = new 二叉树的镜像.TreeNode(1);
        root1.right.right = new 二叉树的镜像.TreeNode(0);
        System.out.println(new 二叉树中和为某一值的路径().FindPath(root1, 8));
    }
    public ArrayList<ArrayList<Integer>> FindPath(二叉树的镜像.TreeNode root, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        FindPathCore(root, target, res, new ArrayList<>());
        return res;
    }

    private void FindPathCore(二叉树的镜像.TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        if(root == null)
            return;
        list.add(root.value);
        target -= root.value;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList(list));
        }else{
            FindPathCore(root.left, target, res, list);
            FindPathCore(root.right, target, res, list);
        }
        list.remove(list.size() - 1);
    }
}

