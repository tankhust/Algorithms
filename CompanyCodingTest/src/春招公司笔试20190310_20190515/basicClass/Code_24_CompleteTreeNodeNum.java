package 春招公司笔试20190310_20190515.basicClass;

public class Code_24_CompleteTreeNodeNum {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int getNodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, getMostLeftLevel(1, head));
    }

    public static int bs(Node head, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (getMostLeftLevel(level + 1, head.right) == h) {
            return (1 << (h - level) )+ bs(head.right, level + 1, h);
        } else {
            return (1 << (h - level - 1)) + bs(head.left, level + 1, h);
        }
    }

    public static int getMostLeftLevel(int level,Node node) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level-1;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(getNodeNum(head));

    }
}
