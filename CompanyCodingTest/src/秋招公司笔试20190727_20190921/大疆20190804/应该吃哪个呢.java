package 秋招公司笔试20190727_20190921.大疆20190804;

import java.util.Scanner;

/**
 * 题目描述：
 * 在零食间里有一个零食柜，里面会半价供应很多好吃的零食，柜子被隔成了一个个小格子，类似一个矩阵，每个格子里会放置由前台小姐姐们精心挑选的零食，并且标上相应的价格。
 *
 * 小A是一个大吃货，每天他都要光顾一次零食间，但是他又要减肥，于是他便对自己做了一个约束，每次只能从里面拿走总价格少于V的零食。这时候问题来了，对于每种零食，小A都有一个内心的满意度，小A希望每次都能吃上让自己最满意的零食。
 *
 * 假设零食柜里每个格只放置一种零食，每种零食的数量是有限的，买完就没有了，零食只能按照整数倍购买，不能只买半件。问小A在有限价格内买到的零食的总满意度最高是多少？
 *
 * 输入
 * 输入包含多组测试数据，每组数组:
 *
 * 第一行有两个正整数 N, T, 分别表示，零食的种类数目 和 小A最多用于购买零食的钱。（1 <= N <= 100, 1 <= T <= 10000）
 *
 * 接下来有N行，每行有三个正整数用空格隔开，按顺序表示 零食需要的价格v，满意度l 和 零食的数量c。(1 <= v <= 100, 1 <= l <= 100 ,1 <= c <= 100)
 *
 * 输出
 * 对于每组测试数据:
 *
 * 输出一个正整数，如果无法购买任何一个零食输出0，否则输出最大的满意度。
 *
 *
 * 样例输入
 * 2 10
 * 1 1 1
 * 1 1 1
 * 3 100
 * 26 100 4
 * 5 1 4
 * 5 2 2
 * 样例输出
 * 2
 * 306
 * @author tankInternshipInterview
 * @create 2019/08/04 19:56
 */
public class 应该吃哪个呢 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int N = sc.nextInt();// 零食的种类数目
//            int T = sc.nextInt();// 小A最多用于购买零食的钱
//            List<Integer> price = new ArrayList<>();
//            List<Integer> satisfied = new ArrayList<>();
//            for (int i = 0; i < N; i++) {
//                int v = sc.nextInt();
//                int l = sc.nextInt();
//                int c = sc.nextInt();
//                for (int j = 0; j < c; j++) {
//                    price.add(v);
//                    satisfied.add(l);
//                }
//            }
//            int[] res = new int[T + 1];
//            for (int i = 0; i < price.size(); i++) {
//                for (int j = T; j >= price.get(i); j--) {
//                    if (res[j] <= res[j - price.get(i)] + satisfied.get(i)) {
//                        res[j] = res[j - price.get(i)] + satisfied.get(i);
//                    }
//                }
//            }
//            System.out.println(res[T]);
//        }
        int[] dp = new int[110];
        int[] q = new int[110];
        int[] num = new int[110];
        int cs, v, w, c;
        int l, r;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                dp[i] = 0;
            }
            for (int i = 1; i <= n; i++) {
                v = sc.nextInt();
                w = sc.nextInt();
                c = sc.nextInt();
                if (c > m / v) {
                    c = m / v;
                }
                for (int b = 0; b < v; b++) {
                    l = 1;
                    r = 1;
                    for (int t = 0; t <= (m - b) / v; t++) {
                        int tmp = dp[t * v + b] - t * w;
                        while (l < r && q[r - 1] <= tmp) {
                            r --;
                        }
                        q[r] = tmp;
                        num[r++] = t;
                        while (l < r && t - num[l] > c) {
                            l++;
                            dp[t * v + b] = Math.max(dp[t * v + b], q[l] + t * w);
                        }

                    }
                }
            }
            System.out.println(dp[m]);
        }
    }
}
