package 秋招公司笔试20190727_20190921.Shopee笔试题20190727;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/a71f3bd890734201986cd1e171807d30?f=discussion
 * 来源：牛客网
 *
 * shopee的办公室非常大，小虾同学的位置坐落在右上角，而大门却在左下角，
 * 可以把所有位置抽象为一个网格（门口的坐标为0，0），小虾同学很聪明，
 * 每次只向上，或者向右走，因为这样最容易接近目的地，但是小虾同学不想让自己
 * 的boss们看到自己经常在他们面前出没，或者迟到被发现。
 * 他决定研究一下如果他不通过boss们的位置，他可以有多少种走法？
 *
 * 输入描述:
 * 第一行 x,y,n (0<x<=30, 0<y<=30, 0<=n<= 20) 表示x,y小虾的座位坐标,n 表示boss的数量（ n <= 20）
 *
 * 接下来有n行, 表示boss们的坐标(0<xi<= x, 0<yi<=y，不会和小虾位置重合)
 *
 * x1, y1
 *
 * x2, y2
 *
 * ……
 *
 * xn, yn
 *
 * 输出描述:
 * 输出小虾有多少种走法
 * 示例1
 * 输入
 * 3 3 2
 * 1 1
 * 2 2
 * 输出
 * 4
 *
 * @author tankInternshipInterview
 * @create 2019/07/27 12:28
 */
public class Shopee的办公室 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        int[][] dp = new int[31][31];
        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            dp[r][c] = -1;
        }
        for (int i = 0; i <= x; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= y; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if(dp[i][j] == -1) continue;
                if(dp[i - 1][j] != -1) dp[i][j] += dp[i - 1][j];
                if(dp[i][j - 1] != -1) dp[i][j] += dp[i][j - 1];
            }
        }
        System.out.print(dp[x][y]);
    }
}
