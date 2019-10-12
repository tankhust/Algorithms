package 牛油面试手撕;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author tankInternshipInterview
 * @create 2019/07/24 22:47
 */
public class 二叉树的遍历问题 {

    public static void main(String[] args) {
        /**
         *        root1
         *          4
         *       2     6
         *     1  3  5  7
         */
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println(new 二叉树的遍历问题().preOrderRecursion(root1, new ArrayList<>()));
        System.out.println(new 二叉树的遍历问题().inOrderRecursion(root1, new ArrayList<>()));
        System.out.println(new 二叉树的遍历问题().postOrderRecursion(root1, new ArrayList<>()));
        System.out.println("========================");
        System.out.println(new 二叉树的遍历问题().preOrderIteration1(root1, new ArrayList<>()));
        System.out.println(new 二叉树的遍历问题().inOrderIteration1(root1, new ArrayList<>()));
        System.out.println(new 二叉树的遍历问题().postOrderIteration1(root1, new ArrayList<>()));
        System.out.println("========================");
//        System.out.println(new 二叉树的遍历问题().preOrderIteration2(root1, new ArrayList<>()));
//        System.out.println(new 二叉树的遍历问题().inOrderIteration1(root1, new ArrayList<>()));
//        System.out.println(new 二叉树的遍历问题().postOrderIteration1(root1, new ArrayList<>()));

    }
    private List<Integer> preOrderRecursion(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preOrderRecursion(root.left, res);
            preOrderRecursion(root.right, res);
        }
        return res;
    }

    private List<Integer> inOrderRecursion(TreeNode root, List<Integer> res) {
        if (root != null) {
            inOrderRecursion(root.left, res);
            res.add(root.val);
            inOrderRecursion(root.right, res);
        }
        return res;
    }

    private List<Integer> postOrderRecursion(TreeNode root, List<Integer> res) {
        if (root != null) {
            postOrderRecursion(root.left, res);
            postOrderRecursion(root.right, res);
            res.add(root.val);
        }
        return res;
    }

    private List<Integer> preOrderIteration1(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                res.add(temp.val);
                temp = temp.left;
            }
            if (!stack.isEmpty()) {
                temp = stack.pop();
                temp = temp.right;
            }
        }
        return res;
    }

    private List<Integer> inOrderIteration1(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            if (!stack.isEmpty()) {
                temp = stack.pop();
                res.add(temp.val);
                temp = temp.right;
            }
        }
        return res;
    }

    private List<Integer> postOrderIteration1(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        TreeNode last = null;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (temp.right == null || temp.right == last) {
                // 右孩子为null或右孩子已遍历
                res.add(temp.val);
                last = temp;
            }else{
                stack.push(temp);// 重新压入
                temp = temp.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
        return res;
    }

//    private List<Integer> preOrderIteration2(TreeNode root,List<Integer> res) {
//        Stack<HashMap<TreeNode, Boolean>> stack = new Stack<>();
//        HashMap<TreeNode, Boolean> map = new HashMap<>();
//        TreeNode temp = root;
//        map.put(temp, false);// true表示第二次访问该结点
//        stack.push(map);
//        while (!stack.isEmpty()) {
//            HashMap<TreeNode, Boolean> tempMap = stack.pop();
//            boolean flag = tempMap.get(temp);
//            if (temp == null) {
//                continue;
//            }
//            if (flag) {
//                res.add(temp.val);
//            }else{
//                tempMap.put(temp.right, false);
//                stack.push(tempMap);
//                tempMap.put(temp.left, false);
//                stack.push(tempMap);
//                tempMap.put(temp, true);
//                stack.push(tempMap);
//            }
//        }
//        return res;
//    }

    private void inOrderIteration2() {

    }

    private void postOrderIteration2() {

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
