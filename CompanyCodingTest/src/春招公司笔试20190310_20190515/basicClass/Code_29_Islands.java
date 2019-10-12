package 春招公司笔试20190310_20190515.basicClass;

public class Code_29_Islands {
    public static int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int row=m.length-1;
        int col = m[0].length-1;
        int res=0;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col ; j++) {
                if (m[i][j] == 1) {
                    //统计被感染的岛屿数量
                    res++;
                }
                inject(m, i, j, row,col);
            }
        }
        return res;
    }

    public static void inject(int[][] m, int i, int j, int row, int col) {
        if (i < 0 || i > row || j < 0 || j > col || m[i][j] != 1) {
            return;
        }
        m[i][j]=2;//被感染
        inject(m, i-1, j, row, col);
        inject(m, i+1, j, row, col);
        inject(m, i, j-1, row, col);
        inject(m, i, j+1, row, col);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                        { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                        { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m2));
    }
}
