package 春招公司笔试20190310_20190515.basicClass;

public class Code_13_RotatePrintSquare {//将正方形矩阵顺时针转动90°C
    public static void RotatePrintSquare(int[][] matrix) {
        int tR=0;
        int dR=matrix.length-1;
        int tC=0;
        int dC = matrix[0].length - 1;
        while (tR <dR) {
            rotateEdge(matrix, tR++, dR--, tC++, dC--);
        }
    }

    public static void rotateEdge(int[][] matrix, int tR, int dR, int tC, int dC) {
        int times=dR-tR;
        for (int i = 0; i < times; ++i) {
            int temp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[tR + times - i][tC];
            matrix[tR + (times - i)][tC] = matrix[dR][tC + (times - i)];
            matrix[dR][tC + (times - i)] = matrix[tR + i][dC];
            matrix[tR + i][dC] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4,}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        RotatePrintSquare(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
