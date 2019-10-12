package 春招公司笔试20190310_20190515.basicClass;


public class Code_33_MinPath {//二维数组，都是正数，只能向右或向下，返回最小的路径和
    public static int minPath1(int[][] m) {
        return process1(m, m.length-1, m[0].length-1);
    }

    public static int process1(int[][] m,int i,int j) {//暴力递归，很多点算了很多次
        int res = m[i][j];
        if (i == 0 && j == 0) {
            return res;
        }
        if (i == 0 && j != 0) {
            return res + process1(m, i, j - 1);
        }
        if (i != 0 && j == 0) {
            return res + process1(m, i - 1, j);
        }
        return res + Math.min(process1(m, i - 1, j), process1(m, i, j - 1));
    }

    //无后效性问题。i，j确定，返回值就确定，可以把返回值装下（i，j二维表）
    //由matrix图可以得到dp图，使用动态规划(dynamic programming)
    public static int minPath2(int[][] m) {
        if (m == null || m.length <= 0 || m[0] == null || m[0].length <= 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0]=m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j-1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    //for test
    public static int[][] generateRandomMatrix(int row, int col) {
        if (row <= 0 || col <= 0) {
            return null;
        }
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = (int) (Math.random() * 10);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

        int[][] m1 = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m1));
        System.out.println(minPath2(m1));
    }
}
