package 秋招公司笔试20190727_20190921.大疆20190804;

import java.util.Scanner;

/**
 * 自从零食间开始免费供应上好的咖啡豆，小杰每天午休后都会来到零食间，按下咖啡机的按钮，等待着杯里弥漫开来的香气把自己淹没，纷乱的思绪也渐渐在水雾中模糊。"小杰，你还有N个bug没修，别摸鱼了，快来解bug！"，一个不合时宜的声音往往会在此时响起，小杰的脑海中瞬间闪过了无数个文件，无数行代码随着咖啡的香气不断滚动。
 * <p>
 * "我是不可能写bug的，这辈子都不可能写bug的...", 小杰一边念叨着，一边开始在脑海里盘算起来。
 * <p>
 * 假设每喝一杯咖啡（喝咖啡的时间忽略不计），就能让自己一小时内的debug效率提升到原来的A倍，一小时内重复喝没用，最多只能喝X杯，太多了晚上会睡不着，并且为了保证可持续发展，每天最多只能专注工作8个小时，而在没喝咖啡的状态下解决每个bug所需要的时间为 t1,t2...tN 分钟。
 * <p>
 * 小杰的咖啡还没有喝完，你能帮他计算出他今天能解完所有bug吗？如果能，最少需要多长时间？
 * <p>
 * 输入
 * 输入包含多组测试数据，每组数组:
 * <p>
 * 第一行有三个正整数 N, A, X, 分别表示，bug的总数，喝一杯咖啡在一小时内debug效率的倍数，最多可以喝的咖啡数目。（1 <= N <= 100, 1 <= A <= 8, 1 <= X <= 8）
 * <p>
 * 第二行有N个正整数，由空格分割开，第i个正整数ti表示解决第i个bug需要的分钟数，（1 <= ti <= 1000）
 * <p>
 * 输出
 * 对于每组测试数据:
 * <p>
 * 输出一个数字，如果不能解完所有bug，则输出0，如果可以，则输出最少需要的分钟数T（T为正整数，如不满一分钟则按一分钟计算，一旦超过8小时则认为不能解完）
 * <p>
 * <p>
 * 样例输入
 * 8 2 8
 * 60 60 60 60 60 60 60 60
 * 4 3 3
 * 333 77 100 13
 * 样例输出
 * 240
 *
 * @author tankInternshipInterview
 * @create 2019/08/04 19:43
 */
public class 咖啡的香气 {
    // ac
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();// bug总数
            int A = sc.nextInt();// 效率倍数
            int X = sc.nextInt();// 最多喝的咖啡数,每小时一杯
            int[] bug = new int[N];
            int totalTimeConsume = 0;
            for (int i = 0; i < N; i++) {
                bug[i] = sc.nextInt();
                totalTimeConsume += bug[i];
            }
            if (X == 8 || X * A >= (int) Math.ceil((double) totalTimeConsume / 60)) {
                // 每小时都喝
                if (Math.ceil(totalTimeConsume / A) <= X * 60) {
                    System.out.println((int) Math.ceil((double) totalTimeConsume / A));
                } else {
                    System.out.println(0);
                }
            } else {
                int res = 0;// 最终需要的时间
                int timeleft = totalTimeConsume - X * A * 60;// 剩下的普通时间
                if (X * 60 + timeleft < 60 * 8) {
                    System.out.println(X * 60 + timeleft);
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}
