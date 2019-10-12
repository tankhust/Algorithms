package 秋招公司笔试20190727_20190921.快手20190825;

import java.util.Scanner;

/**
 * 版本升级判定
 *
 * @author tankInternshipInterview
 * @create 2019/08/25 16:25
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] res = new boolean[n];
        int a = 0;
        while (n > 0) {
            n--;
            String version1 = sc.next();
            String version2 = sc.next();
            char[] chars1 = version1.toCharArray();
            char[] chars2 = version2.toCharArray();
            int i = 0, j = 0;
            res[a] = false;
            for (; i < chars1.length && j < chars2.length; i++, j++) {
                if (chars1[i] != chars2[j]) {
                    break;
                }
            }
            if (i == chars1.length && j < chars2.length) {// version1遍历完了，version2还没遍历完
                String temp = version2.substring(j);
                if (temp.charAt(0) == '.') {
                    temp = temp.substring(1);
                }
                String[] split = temp.split("\\.");
                for (int k = 0; k < split.length; k++) {
                    if (!"0".equals(split[k])) {
                        res[a] = true;
                        break;
                    }
                }
            } else if (i < chars1.length && j < chars2.length) {
                if ((version1.charAt(i) - '0') < (version2.charAt(j) - '0')) {
                    res[a] = true;
                }
            }
            a++;
        }
        for (int i = 0; i < a; i++) {
            System.out.println(res[i]);
        }
    }
}
