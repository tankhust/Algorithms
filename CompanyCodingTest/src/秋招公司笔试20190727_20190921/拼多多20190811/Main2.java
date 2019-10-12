package 秋招公司笔试20190727_20190921.拼多多20190811;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/08/11 14:51
 */
public class Main2 {
    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int L = sc.nextInt();
//        int N = sc.nextInt();
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = sc.nextInt();
//        }
//        Arrays.sort(arr);
//        int sumA = 0;
//        int sumB = 0;
//        for (int i = 0; i < N; i++) {
//            sumA += arr[i] > L / 2 ? (L - arr[i]) : arr[i];// 以0位置为基点
//            sumB += Math.abs(L / 2 - arr[i]);// 以N/2位置为基点
//        }
//        int sum = 0;
//        // 需要跨0
//        if (sumA < sumB) {
//            for (int i = 0; i < N; i++) {
//                sum += arr[i] > L / 2 ? (arr[i] - L) : arr[i];
//            }
//            int average = sum / N;// 找到中心位置
//            sum = 0;// 此时统计距离
//            int l = average;
//            int r = average;
//            for (int i = 0; i <N; i++) {
//                int temp = arr[i] > L / 2 ? (arr[i] - L) : arr[i];
//                if (temp < average) {
//                    sum += l - temp;
//                    l = temp;
//                }else {
//                    sum += temp - r;
//                    r = temp;
//                }
//            }
//        }else{
//            //不需要跨0
//            for (int i = 0; i < N; i++) {
//                sum += arr[i];
//            }
//            int average = sum / N;
//            sum = 0;// 此时统计距离
//            int l = average;
//            int r = average;
//            for (int i = 0; i <N; i++) {
//                int temp = arr[i] > L / 2 ? (arr[i] - L) : arr[i];
//                if (temp < average) {
//                    sum += l - temp;
//                    l = temp;
//                }else {
//                    sum += temp - r;
//                    r = temp;
//                }
//            }
//        }
//        System.out.println(sum);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 0;
        int min = L - 1;
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int temp;
            if (arr[i - 1] - max - 1 > N - 1 - arr[i - 1] + min) {
                temp = N - 1 - arr[i - 1] + min;
            }else{
                temp = arr[i - 1] - max - 1;
            }
            dp[i] = dp[i - 1] + temp;
            max = Math.max(max, arr[i - 1]);
            min = Math.min(min, arr[i - 1]);
        }
        System.out.println(dp[N]);
    }
}
