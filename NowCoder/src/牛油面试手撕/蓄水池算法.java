package 牛油面试手撕;

import java.util.Random;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/08/04 10:56
 */
public class 蓄水池算法 {
    private  Random random = new Random();
    private int[] pool; // 所有数据
    private final int N = 100000; // 数据规模
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
//        int n = sc.nextInt();
//        int[] pool = new int[n];
//        for (int i = 0; i < n; i++) {
//            pool[i] = sc.nextInt();
//        }
        蓄水池算法 solution = new 蓄水池算法();
        solution.setUp();
        int[] res = solution.method(k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public void setUp(){
        // 初始化
        pool = new int[N];
        for (int i = 0; i < N; i++) {
            pool[i] = i;
        }
    }

    private int[] method(int k) {
        int[] result = new int[k];
        // 初始化 0 ~ k位置上的数
        for (int i = 0; i < k; i++) {
            result[i] = pool[i];
        }
        // 第k+1个元素开始，概率采样。以k/i的概率替换掉1~k上的数
        for (int i = k; i < pool.length; i++) {
            int r = random.nextInt(i + 1);
            if (r < k) {
                result[r] = pool[i];
            }
        }
        return result;
    }
}
