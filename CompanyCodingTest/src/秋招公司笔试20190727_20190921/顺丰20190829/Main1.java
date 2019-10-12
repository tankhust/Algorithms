package 秋招公司笔试20190727_20190921.顺丰20190829;

import java.util.Scanner;

/**
 * 求最长的特殊子序列
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 现有一个长度为n的序列，需要你求出最长的子序列，使得其长度最长，并且这个子序列是满足性质C的
 *
 * 子序列的定义：现有,则为一个子序列
 *
 * 性质C的定义：现有子序列，若,则称子序列满足性质C
 *
 * 输入
 * 第一行一个数n，代表序列的长度 接下来一行n个数ai，代表序列中的每个数
 *
 * 1≤n≤100000,1≤ai≤n
 *
 * 输出
 * 一行一个数，代表最长的满足性质C的子序列的长度
 *
 *
 * 样例输入
 * 5
 * 1 2 1 3 4
 * 样例输出
 * 4
 * @author tankInternshipInterview
 * @create 2019/08/29 20:05
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int size = 0;
        int[] temp = new int[n];
        for (int num : arr) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j)/2;
                if (temp[m] <= num) {
                    i = m + 1;
                }else{
                    j = m;
                }
            }
            temp[i] = num;
            if(i == size) ++size;
        }
        System.out.println(size);
    }
}
