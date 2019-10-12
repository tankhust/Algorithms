package 秋招公司笔试20190727_20190921.网易互娱20190907;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/07 19:04
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            // 构建一颗树
            TreeNode[] nodes = new TreeNode[N];
            for (int i = 0; i < N; i++) {
                nodes[i] = new TreeNode(-1);//权值为-1表示未被更新
            }
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                int val = sc.nextInt();
                int leftInx = sc.nextInt();
                int rightInx = sc.nextInt();
                if (leftInx != -1) {
                    nums[leftInx] = 1;
                }
                if (rightInx != -1) {
                    nums[rightInx] = 1;
                }
                nodes[i].val = val;
                nodes[i].left = leftInx != -1 ? nodes[leftInx] : null;
                nodes[i].right = rightInx != -1 ? nodes[rightInx] : null;
            }
            int root = -1;// 找到根节点
            for (int i = 0; i < N; i++) {
                if (nums[i] != 1) {
                    root = i;
                }
            }
            //层序遍历，判断是否为递增树
            boolean isAscTree = true;
            int pre = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(nodes[root]);
            while (!queue.isEmpty()) {
                int cur = 0;
                int cnt = queue.size();
                while (cnt-- > 0) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        continue;
                    }
                    cur += node.val;
                    if(node.left != null)
                        queue.add(node.left);
                    if(node.right != null)
                        queue.add(node.right);
                }
                if (cur > pre) {
                    pre = cur;
                }else{
                    isAscTree = false;
                    break;
                }
            }
            System.out.println(isAscTree ? "YES" : "NO");
        }
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
