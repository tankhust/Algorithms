package 秋招公司笔试20190727_20190921.pdd20190925;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/25 15:13
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[] arr2 = new int[2 * m];
        for (int i = 0; i < 2 * m; i++) {
            arr2[i] = arr[2 * m - i - 1];
        }
        long sum = 0;
        for (int i = 0; i < 2 * m; i++) {
            sum += arr[i] * arr2[i];
        }
        System.out.println(sum / 2);
    }
}
