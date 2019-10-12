package 秋招公司笔试20190727_20190921.小红书20190818;

import java.util.Scanner;

/**
 * 笔记精选
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 薯队长写了n篇笔记， 编号从 1～n，每篇笔记都获得了不少点赞数。 薯队长想从中选出一些笔记，作一个精选集合。挑选的时候有两个规则：
 *
 * 1.    不能出现连续编号的笔记。
 *
 * 2.    总点赞总数最多
 *
 * 如果满足 1，2条件有多种方案，挑选笔记总数最少的那种。
 *
 * 输入
 * 输入包含两行。第一行整数 n 表示多少篇笔记。
 *
 * 第二行 n 个整数分别表示 n 篇笔记的获得的点赞数。 （ 0 < n <= 1000, 0 <= 点赞数 <= 1000)
 *
 * 输出
 * 输出两个整数x y。空格分割。
 *
 * x 表示总点赞数，y表示挑选的笔记总数。
 *
 *
 * 样例输入
 * 4
 * 1 2 3 1
 * 样例输出
 * 4 2
 *
 * 提示
 * 挑选了第1和第3篇。总共 1 + 3 = 4 个赞。
 * @author tankInternshipInterview
 * @create 2019/08/18 16:00
 */
public class 笔记精选 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        int[] kinds = new int[n + 1];
//        kinds[0] = 0;
        kinds[1] = 1;
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i] >= dp[i - 1] + nums[i]) {
                dp[i + 1] = dp[i];
                kinds[i + 1] = kinds[i];
            }else{
                dp[i + 1] = dp[i - 1] + nums[i];
                kinds[i + 1] = kinds[i - 1] + 1;
            }
        }
        System.out.print(dp[n] + " ");
        System.out.print(kinds[n]);
    }
}
