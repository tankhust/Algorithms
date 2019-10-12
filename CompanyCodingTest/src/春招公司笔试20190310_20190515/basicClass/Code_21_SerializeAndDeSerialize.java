package 春招公司笔试20190310_20190515.basicClass;

import java.util.LinkedList;
import java.util.Queue;

public class Code_21_SerializeAndDeSerialize {//序列化和反序列化
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value=data;
        }
    }

    public static String serializeByPre(Node head) {//先序
        if (head == null) {
            return "#!";
        }
        String res=head.value + "!";
        res += serializeByPre(head.left);
        res += serializeByPre(head.right);
        return res;
    }

    public static Node deserializeByPreString(String preStr) {
        String[] str = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i !=str.length ; i++) {
            queue.offer(str[i]);
        }
        return deserializeByPreStringCore(queue);
    }

    public static Node deserializeByPreStringCore(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = deserializeByPreStringCore(queue);
        head.right = deserializeByPreStringCore(queue);
        return head;
    }

}
