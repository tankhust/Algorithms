package 秋招公司笔试20190727_20190921.拼多多20190811;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/08/11 14:51
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 2 < n < 3000
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 10 -1 0 1 3
        Arrays.sort(arr);
//        int i = 0, j = 2;
        double average = 0;
        double varianceSum = Integer.MAX_VALUE;
        double varianceTemp = 0;
        for (int i = 0; i < n - 2; i++) {
            average = 0;
            for (int j = i; j < i + 3; j++) {
                average += arr[j];
            }
            average = average/3.0;
            varianceTemp = 0;
            for (int j = i; j < i + 3; j++) {
                varianceTemp += (arr[j] - average) * (arr[j] - average);
            }
            varianceSum = Math.min(varianceSum, varianceTemp);
        }
        System.out.println(String.format("%.2f",varianceSum/3.0));
    }
}
