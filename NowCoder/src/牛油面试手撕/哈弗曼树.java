package 牛油面试手撕;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 请设计一个算法，给一个字符串进行二进制编码，使得编码后字符串的长度最短。
 *  * <p>
 *  * 输入描述:
 *  * 每组数据一行，为待编码的字符串。保证字符串长度小于等于1000。
 *  * 输出描述:
 *  * 一行输出最短的编码后长度。
 *  * 输入例子:
 *  * MT-TECH-TEAM
 *  * 输出例子:
 *  * 33
 *
 * @author tankInternshipInterview
 * @create 2019/08/15 21:13
 */
public class 哈弗曼树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            System.out.println(createHuffman(s));
        }
    }

    private static int createHuffman(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        PriorityQueue<HuffManTreeNode> queue = new PriorityQueue<>((o1, o2) -> (o1.weight - o2.weight));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.offer(new HuffManTreeNode(entry.getValue(), entry.getKey()));
        }
        while (queue.size() > 1) {
            HuffManTreeNode left = queue.poll();
            HuffManTreeNode right = queue.poll();
            HuffManTreeNode fatherNode = new HuffManTreeNode(left.weight + right.weight);
            fatherNode.left = left;
            fatherNode.right = right;
            queue.offer(fatherNode);
        }
        return getLength(queue.peek(), 1);
    }

    private static int getLength(HuffManTreeNode node, int depth) {
        if (node == null) {
            return 0;
        }
        return ((node.c == null) ? 0 : node.weight) + getLength(node.left, depth + 1) + getLength(node.right, depth + 1);
    }
}

class HuffManTreeNode {
    int weight;
    Character c;
    HuffManTreeNode left;
    HuffManTreeNode right;

    HuffManTreeNode(int weight, char c) {
        this.weight = weight;
        this.c = c;
    }

    HuffManTreeNode(int weight) {
        this.weight = weight;
    }
}
