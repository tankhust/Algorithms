package 春招公司笔试20190310_20190515.拼多多提前批笔试3_10;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/10 17:58
 */
public class Main4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int maxLen = 2500;
        int[] l1 = new int[maxLen];
        int[] l2 = new int[maxLen];
        int n1 = s1.length();
        int n2 = s2.length();
        int tmp = 0;
        for (int i = 1; i <= n1; ++i) {
            tmp += (s1.charAt(i - 1) == '(') ? 1 : 0;
            l1[i] = tmp;
        }
        tmp = 0;
        for (int i = 1; i <= n2; ++i) {
            tmp += (s2.charAt(i - 1) == '(') ? 1 : 0;
            l2[i] = tmp;
        }
        int[][] f = new int[maxLen][maxLen];
        f[0][0] = 1;
        //第一个字符串前i个和第二个字符串前j个所构成的合法字符串的可能为  第一个字符串前i - 1个和第二个字符串的j个
        // 以及 第一个字符串前i个和第二个字符串的j - 1个 所构成的合法字符串
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (2 * (l1[i] + l2[j]) >= (i + j)) {
                    if (i > 0) f[i][j] += f[i - 1][j];
                    if (j > 0) f[i][j] += f[i][j - 1];
                    f[i][j] %= 1000000007;
                }
            }
        }
        System.out.println(f[n1][n2]);
    }
}
