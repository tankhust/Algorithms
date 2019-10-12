package 秋招公司笔试20190727_20190921.网易互娱20190907;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/07 19:04
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt();// 最少间隔天数
            int M = sc.nextInt();// 固定M天喝咖啡
            int[] arr = new int[31];
            for (int i = 0; i < M; i++) {
                arr[sc.nextInt()] = 1;
            }
            if (K == 0) {
                System.out.println(30);// 每天都可以喝咖啡
                continue;
            }
            for (int i = 1; i < 30; i++) {
                if (arr[i] == 1) {// 这天必喝
                    int temp = K;
                    while (temp > 0) {
                        if (i - temp >= 1 && arr[i - temp] == 0) {// i - K天不能喝
                            arr[i - temp] = -1;// -1表示不能喝
                        }
                        if (i + temp <= 30 && arr[i + temp] == 0) {// i + K天不能喝
                            arr[i + temp] = -1;
                        }
                        temp--;
                    }
                }
            }
            int res = 0;
            for (int i = 1; i <= 30; i++) {
                if (arr[i] == 1) {
                    res++;
                }
            }
            int i = 1;
            while (i <= 30) {
                if (arr[i] == 0) {
                    int startIndex = i;
                    int endIndex = i + 1;
                    while (endIndex <= 30 && arr[endIndex] == 0) {
                        endIndex++;
                    }
                    res += (endIndex - startIndex + 1) / (K + 1);
                    i = endIndex;
                    continue;
                }
                i++;
            }
            System.out.println(res);
        }
    }
}
/*
2
0 10
1 2 3 4 5 6 7 8 9 10
1 15
1 3 5 7 9 11 13 15 17 19 21 23 25 27 29
 */