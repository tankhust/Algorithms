package 剑指offer练习;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * @author tankInternshipInterview
 * @create 2019/07/20 01:03
 */
public class 字符流中第一个不重复的字符 {
    public static void main(String[] args) {
        字符流中第一个不重复的字符 solution = new 字符流中第一个不重复的字符();
        solution.insert('g');
        solution.insert('o');
//        solution.insert('o');
//        solution.insert('g');
//        solution.insert('l');
//        solution.insert('e');
        System.out.println(solution.firstAppearOnce());
    }

    private Queue<Character> queue = new LinkedList<>();
    private int[] cnt = new int[256];

    public void insert(char ch) {
        cnt[ch]++;
        queue.offer(ch);
        while (!queue.isEmpty() && cnt[queue.peek()] > 1) {
            queue.poll();
        }
    }

    public char firstAppearOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
