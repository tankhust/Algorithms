package 秋招公司笔试20190727_20190921.腾讯20190901;

import java.util.*;

/**
 * 排队
 * @author tankInternshipInterview
 * @create 2019/09/01 19:50
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[][] ab = new int[n][2];
        for (int i = 0; i < n; i++) {
            ab[i][0] = sc.nextInt();
            ab[i][1] = sc.nextInt();
        }
        Arrays.sort(ab, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] - o1[0] != 0) {
                    return o2[0] - o1[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        int res1 = 0;
        for (int i = 0; i < ab.length; i++) {
            res1 += i * ab[i][0] + (ab.length - i - 1) * ab[i][1];
        }
        Arrays.sort(ab, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] - o2[1] != 0) {
                    return o1[1] - o2[1];
                }else{
                    return o2[0] - o1[0];
                }
            }
        });
        int res2 = 0;
        for (int i = 0; i < ab.length; i++) {
            res2 += i * ab[i][0] + (ab.length - i - 1) * ab[i][1];
        }
        int res = Math.min(res1, res2);
        System.out.println(res);
    }
}
