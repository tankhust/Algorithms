package 剑指offer练习;

import java.util.ArrayList;

/**
 * @author tankInternshipInterview
 * @create 2019/07/12 08:02
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        System.out.println(new 顺时针打印矩阵().printMatrix(matrix));
    }
    private ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> res = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while(r1 <= r2 && c1 <= c2){
            for(int i = c1; i <= c2; i++){
                res.add(matrix[r1][i]);
            }
            for(int i = r1 + 1; i <= r2; i++){
                res.add(matrix[i][c2]);
            }
            // 若r1 == r2 则重复添加
            if(r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    res.add(matrix[r2][i]);
                }
            }
            if(c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    res.add(matrix[i][c1]);
                }
            }
            r1++; r2--; c1++; c2--;
        }
        return res;
    }
}
