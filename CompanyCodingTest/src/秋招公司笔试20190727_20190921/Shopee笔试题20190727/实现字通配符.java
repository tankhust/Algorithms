package 秋招公司笔试20190727_20190921.Shopee笔试题20190727;

import java.util.Scanner;

/**
 * 在Linux Shell命令下通配符'*'表示0个或多个字符, 现编写一段代码实现通配符'*'的功能，
 * 注意只需要实现'*', 不用实现其他通配符。
 * <p>
 * 第一行输入通配字符串
 * 第二行输入要匹配查找的字符串
 * <p>
 * 输出描述:
 * 输出所有匹配的字串起始位置和长度，每行一个匹配输出
 * 如果不匹配，则输出 -1 0
 * 如果有多个按照起始位置和长度的正序输出。
 * <p>
 * 输入例子1:
 * shopee*.com
 * shopeemobile.com
 * <p>
 * 输出例子1:
 * 0 16
 * <p>
 * 例子说明1:
 * 0 起始位置，16长度
 * <p>
 * 输入例子2:
 * *.com
 * shopeemobile.com
 * <p>
 * 输出例子2:
 * 0 16
 * 1 15
 * 2 14
 * 3 13
 * 4 12
 * 5 11
 * 6 10
 * 7 9
 * 8 8
 * 9 7
 * 10 6
 * 11 5
 * 12 4
 * <p>
 * 输入例子3:
 * o*m
 * shopeemobile.com
 * <p>
 * 输出例子3:
 * 2 5
 * 2 14
 * 7 9
 * 14 2
 * <p>
 * 输入描述:
 *
 * @author tankInternshipInterview
 * @create 2019/07/27 16:39
 */
public class 实现字通配符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.next();
        String string2 = scanner.next();
        int head = 0;
        int length1 = string1.length();
        int length2 = string2.length();
        int sign = 0;

        if (string1.charAt(0) == '*' && string1.length() == 1) {
            for (int i = 0; i < length2; i++) {
                for (int j = 1; j <= length2 - i; j++) {
                    System.out.println(String.valueOf(i) + " " + String.valueOf(j));
                }
            }
        } else {
            while (head < length2) {
                if (equal(head, string1, string2, 0)) sign = 1;
                head++;
            }
            if (sign == 0) System.out.println("-1 0");
        }
    }

    public static boolean equal(int head, String string1, String string2, int parent) {
        int offset1 = 0, offset2 = parent;
        while (offset1 < string1.length() && head + offset2 < string2.length()) {
            if (offset1 + 1 < string1.length() && string1.charAt(offset1) == '*' && string1.charAt(offset1 + 1) != string2.charAt(head + offset2)) {
                offset2 += 1;
            } else if (string1.charAt(offset1) == '*') {
                offset1 += 2;
                offset2 += 1;
            } else if (string1.charAt(offset1) == string2.charAt(head + offset2)) {
                offset1 += 1;
                offset2 += 1;
            } else {
                return false;
            }
        }
        if (offset1 < string1.length()) return false;
        System.out.println(String.valueOf(head) + " " + String.valueOf(offset2));
        if (offset1 == string1.length() && head + offset2 < string2.length()) {
            equal(head, string1, string2, offset2);
        }
        return true;
    }
}
