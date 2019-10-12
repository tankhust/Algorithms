package 秋招公司笔试20190727_20190921.奇虎20190831;

import java.util.Scanner;

/**
 * 散步
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 饭后散步是一个很好的习惯，一天晚上，小A在一条笔直的路上散步，起点在路上某处，但是因为路上没有标识，他并不知道这个起点位于路上的那个位置，现在将道路划分为N-1个等距的部分，你可以把这条路当成一个数轴，道路上的结点标记为1~N，起点只可能是这N个点中的一个。
 *
 * 但是小A还提供了一个重要信息，他每隔一段时间就会用手机看一下自己走了多远，记作D，但是他并不记得他是朝着哪个方向走的，唯一可以确定的是，在两次看手机的间隔中他不会改变方向，每次看完手机后他可能继续向前或者回头走。
 *
 * 那么问题来了，已知他在散步过程中始终在1~N的范围内，那么符合上述条件的起点可能有多少个呢？
 *
 * 输入
 * 输入第一行包含一个正整数N，M，N表示道路的长度，也是数轴上点的数量，M是小A提供的D的数量。(N,M<=20000)
 *
 * 接下来有M行，每行一个正整数D，表示小A朝着某个方向走了D个单位。(D<=20000)
 *
 * 输出
 * 输出仅包含一个整数，表示可能的起点的数量。
 *
 *
 * 样例输入
 * 10 3
 * 5
 * 2
 * 6
 * 样例输出
 * 8
 * @author tankInternshipInterview
 * @create 2019/08/31 17:28
 */
public class 散步 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();// 数轴上点的数量
        int M = sc.nextInt();
        int[] arr = new int[M];// 走的每段长度
        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            int newStart = i;
            int j = 0;
            for (j = 0; j < M; j++) {
                if (newStart < (N + 1) / 2) {
                    if (newStart - arr[j] <= 0) {// 不能往左走，往右走
                        newStart += arr[j];
                        if (newStart > N) {
                            break;
                        }
                    }else{
                        newStart -= arr[j];
                    }
                }else{
                    if (newStart + arr[j] > N) {// 不能往右走，往左走
                        newStart -= arr[j];
                        if (newStart <= 0) {
                            break;
                        }
                    }else{
                        newStart += arr[j];
                    }
                }
            }
            if (j == M) {
                res++;
            }
        }
        System.out.println(res);
    }
}


//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        System.out.println(8);
//    }
//}