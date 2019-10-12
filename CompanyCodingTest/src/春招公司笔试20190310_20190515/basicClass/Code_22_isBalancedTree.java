package 春招公司笔试20190310_20190515.basicClass;

public class Code_22_isBalancedTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalancedTree(Node head) {
        boolean[] res = new boolean[1];//boolean[] res长度为1，其功能相当于一个全局的boolean变量
        res[0] = true;
        getTreeHeight(head,1,res);
        return res[0];
    }

    public static int getTreeHeight(Node node,int level,boolean[] res) {
        if (node == null) {
            return level;
        }
        int lH = getTreeHeight(node.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getTreeHeight(node.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0]=false;
        }
        return Math.max(lH, rH);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
//        head.right.left = new Node(6);
//        head.right.right = new Node(7);
        System.out.println(isBalancedTree(head));
    }
}
