package 秋招公司笔试20190727_20190921.滴滴20190827;

import java.util.Scanner;

/**
 * 算式转移
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 给出一个仅包含加减乘除四种运算符的算式(不含括号)，如1+2*3/4，在保持运算符顺序不变的情况下，现在你可以进行若干次如下操作：如果交换相邻的两个数，表达式值不变，那么你就可以交换这两个数。
 *
 * 现在你可以进行任意次操作，使得算式的数字序列字典序最小，然后输出结果，数字之间的字典序定义为若a<b则a的字典序小于b。
 *
 * 输入
 * 第一行包含一个整数n，表示算式的长度，即包含n个数字和n-1个运算符。(1≤n≤100000)。
 *
 * 第二行包含一个含有n个非0整数和n-1个运算符的算式，整数与运算符用空格隔开，运算符包括“+，-，*，/”，整数的绝对值不超过1000。
 *
 * 输出
 * 按要求输出字典序最小的表达式，数字与符号之间用空格隔开。
 *
 *
 * 样例输入
 * 6
 * 3 + 2 + 1 + -4 * -5 + 1
 * 样例输出
 * 1 + 2 + 3 + -5 * -4 + 1
 * @author tankInternshipInterview
 * @create 2019/08/27 18:56
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        String[] strr = str.split(" ");
        String[] nums = new String[n];
        String[] tags = new String[n - 1];
        int j = 0, k = 0;
        for (int i = 0; i < strr.length; i++) {
            if (i % 2 == 0) {
                nums[j++] = strr[i];
            }else{
                tags[k++] = strr[i];
            }
        }
        for (int i = 1; i < n; i++) {
            String temp = nums[i - 1];
            nums[i - 1] = nums[i];
            nums[i] = temp;
//            isEqualAfterSwap(nums, tags, i);
        }
//        String[]
        System.out.println(str);

//        String[] strr = str.split(" ");
//        num
    }

    private boolean isEqualAfterSwap(String[] nums, String[] tags, int i) {
        String temp = nums[i - 1];
        nums[i - 1] = nums[i];
        nums[i] = temp;

        return false;
    }
}
