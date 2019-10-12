package 秋招公司笔试20190727_20190921.贝壳找房20190810;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 举重大赛
 *
 * 题目描述：
 * 举重大赛开始了，为了保证公平，要求比赛的双方体重较小值要大于等于较大值的90%，那么对于这N个人最多能进行多少场比赛呢，任意两人之间最多进行一场比赛。
 *
 * 输入
 * 第一行N，表示参赛人数（2<=N<=10^5）
 *
 * 第二行N个正整数表示体重（0<体重<=10^8）
 *
 * 输出
 * 一个数，表示最多能进行的比赛场数
 *
 *
 * 样例输入
 * 5
 * 1 1 1 1 1
 * 样例输出
 * 10
 * @author tankInternshipInterview
 * @create 2019/08/10 18:55
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int times = 0;// 比赛次数
        for (int i = 0; i < n; i++) {
            int temp = (int)(10.0/9 * arr[i]);
            for (int j = i+1; j < n && arr[j] <= temp; j++) {
                if (arr[j] <= temp) {
                    ++times;
                }
            }
        }
        System.out.println(times);
    }
}
