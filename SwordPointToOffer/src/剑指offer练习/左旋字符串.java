package 剑指offer练习;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * @author tankInternshipInterview
 * @create 2019/07/18 23:37
 */
public class 左旋字符串 {
    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(new 左旋字符串().leftRotateString(str,3));
    }

    public String leftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n < 0) {
            return "";
        }
        n %= str.length();
        char[] chars = str.toCharArray();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }
        for (int i = n, j = str.length() - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }
        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
