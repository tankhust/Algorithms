package 秋招公司笔试20190727_20190921.贝壳找房20190810;

import java.util.Scanner;

/**
 * 计算绝对值
 *
 * 题目描述：
 * 给出n个正整数，要求找出相邻两个数字中差的绝对值最小的一对数字，如果有差的绝对值相同的，则输出最前面的一对数。
 *
 * 2<n<=100，正整数都在10^16范围内
 *
 * 输入
 * 输入包含2行，第一行为n，第二行是n个用空格分隔的正整数。
 *
 * 输出
 * 输出包含一行两个正整数，要求按照原来的顺序输出
 *
 *
 * 样例输入
 * 9
 * 1 3 4 7 2 6 5 12 32
 * 样例输出
 * 3 4
 * @author tankInternshipInterview
 * @create 2019/08/10 18:55
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        long[] res = new long[n - 1];
        for (int i = 1; i < arr.length; i++) {
            res[i - 1] = Math.abs(arr[i - 1] - arr[i]);
        }
        int minIndex = 0;
        long minStart = res[0];
        for (int i = 1; i < res.length; i++) {
            if(res[i] < minStart){
                minStart = res[i];
                minIndex = i;
            }
        }
        System.out.print(arr[minIndex]+ " ");
        System.out.println(arr[minIndex + 1]);
    }
}
