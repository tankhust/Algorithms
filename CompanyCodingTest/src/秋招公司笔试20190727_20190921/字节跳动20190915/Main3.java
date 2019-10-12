package 秋招公司笔试20190727_20190921.字节跳动20190915;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/15 16:58
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];// dp[i][j]表示先取数字的人最多能取到的数字和
        int[] sum = new int[n + 1];// sum[i]表示前i个数字之和
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            if (i > 1) {
                sum[i] = sum[i - 1] + arr[i];
            }else{
                sum[i] = arr[i];
            }
        }
        // i~i之间的数为arr[i]
        for (int i = 0; i <= n; i++) {
            dp[i][i] = arr[i];
        }
        for (int len = 1; len < n; len++) {
            for (int i = 1; i <= n - len; i++) {
                // i~i+len（含）之间的数字。分为拿i位置和拿i+len位置两种情况
                // 拿了i位置之后，之后能拿的数字就是剩余的数字减去后手人拿的数字和
                dp[i][i + len] = Math.max(arr[i] + sum[i + len] - sum[i] - dp[i + 1][i + len],
                        arr[i + len] + sum[i + len - 1] - sum[i - 1] - dp[i][i + len - 1]);
            }
        }
        System.out.println(dp[1][n]);
    }
}
