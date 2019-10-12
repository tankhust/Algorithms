package 秋招公司笔试20190727_20190921.滴滴20190827;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/08/27 18:56
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = sc.nextInt();
        int cost = sc.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = sc.nextInt();
        }
    }
}
