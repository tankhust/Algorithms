package 秋招公司笔试20190727_20190921.大疆20190804;

import java.util.*;

/**
 * 题目描述：
 * 最近DJI发布了一款Robomaster S1机器人，小伙伴们都沉迷其中不能自拔。小J为了能够在竞速比赛中迅速获胜，他决定利用开发的优势，在里面植入一套最优化的寻路算法。
 *
 * 小伙伴们为了提高难度，决定调整规则如下: 在比赛场地内预先设置N个路标，路标编号从0到N-1，S1只能沿直线在两个路标之间移动，且规定部分路标点之间是不能进行移动的。
 *
 * 比赛场地内的S1机器人从编号为0的路标出发，然后裁判给出随机一个路标，要求S1机器人以尽可能快的速度达到路标位置，每轮比赛都会从头开始，最终总时间最短者获胜。
 *
 * 其中会确保每两个路标之间肯定存在至少一条路径是可以到达的。
 *
 * 小J在比赛开始前就已经得知了所有路标的具体位置，和相互之间的距离和移动需要的时间。但是他需要编写一个程序，以确保能够随时响应裁判的命令。你能比小J更快吗？
 *
 * 输入
 * 输入包含多组测试数据，每组数组:
 *
 * 第一行有三个正整数 N, P，C， 分别表示 路标的数目， 可以移动的路标的通路的数目， 以及裁判进行比赛的轮数。 (1 < N <= 200,  N * (N - 1) / 2 <= P <= 400, N - 1 <= C <= 10)
 *
 * 接下来的P行，每行输入三个正整数 A, B, T，表示从 路标A到路标B需要时间T。 (0 <= A, B < N, 1 <= T <= 100)
 *
 * 然后接下来的C行，每行输入一个正整数 X，表示裁判每轮比赛给出的要达到的路标编号 (0 < X < N)
 *
 * 输出
 * 对于每组测试数据:
 *
 * 输出一个正整数，进行完所有比赛后，总时间最短是多少?
 *
 *
 * 样例输入
 * 2 1 1
 * 0 1 10
 * 1
 * 4 5 3
 * 0 1 15
 * 1 2 15
 * 0 3 50
 * 1 3 30
 * 2 3 10
 * 2
 * 1
 * 3
 * 样例输出
 * 10
 * 85
 * @author tankInternshipInterview
 * @create 2019/08/04 20:36
 */
public class 机器人大战 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int c= sc.nextInt();
            List<HashMap<Integer, Integer>> map = new ArrayList<>(n);
            for (int i = 0; i < p; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int t = sc.nextInt();
                map.set(a, new HashMap<Integer, Integer>(b,t));
                map.set(b, new HashMap<Integer, Integer>(a,t));
            }
            List<Integer> endp = new ArrayList<>(c);
            for (int i = 0; i < c; i++) {
                endp.set(i, sc.nextInt());
            }
            List<Integer> visit = new ArrayList<>(n);
            Collections.fill(visit,0);
            List<Integer> res = new ArrayList<>(n);
            Collections.fill(res, Integer.MAX_VALUE);
            res.set(0, 0);
//            PriorityQueue<map>
        }
    }
}
