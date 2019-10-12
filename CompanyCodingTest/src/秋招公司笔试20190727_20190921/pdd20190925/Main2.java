package 秋招公司笔试20190727_20190921.pdd20190925;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/25 16:36
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] starts = new int[m];
        int[] ends = new int[m];
        for (int i = 0; i < m; i++) {
            starts[i] = sc.nextInt();
            ends[i] = sc.nextInt();
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int sum = 0;
        for (int i = 0, j = 0; i < m; i++) {
            if (i == m - 1 || starts[i + 1] > ends[i]) {
                int temp = ends[i] - starts[i] + 1;
                sum += temp;
                System.out.println(sum);
                j = i + 1;
            }
        }
    }
}
