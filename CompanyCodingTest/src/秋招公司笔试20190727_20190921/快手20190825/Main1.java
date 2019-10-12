package 秋招公司笔试20190727_20190921.快手20190825;

import java.util.Scanner;

/**
 * 版本升级判定
 *
 * @author tankInternshipInterview
 * @create 2019/08/25 16:25
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] res = new boolean[n];
        int a = 0;
        while (n > 0) {
            n--;
            String version1 = sc.next();
            String version2 = sc.next();
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            int i = 0;
            int len = Math.min(v1.length, v2.length);
            res[a] = false;
            while (i < len) {
                if (Integer.valueOf(v1[i]).intValue() == Integer.valueOf(v2[i]).intValue()) {
                    i++;
                    continue;
                }
                if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[i])) {
                    res[a] = true;
                    break;
                }
            }
            if (!res[a] && v1.length < v2.length) {
                while (i < v2.length) {
                    if (Integer.valueOf(v2[i]) > 0) {
                        res[a] = true;
                    }
                    i++;
                }
            }
            a++;
        }
        for (int i = 0; i < a; i++) {
            System.out.println(res[i]);
        }
    }
}
