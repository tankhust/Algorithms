package 剑指offer练习;

import java.util.Arrays;

/**
 *  给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 *  其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @author tankInternshipInterview
 * @create 2019/07/20 00:44
 */
public class 构建乘积数组 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new 构建乘积数组().multiply(A)));
    }

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, cur = 1; i < n; cur *= A[i], i++) {
            B[i] = cur;
        }
        for (int i = n - 1, cur = 1; i >= 0; cur *= A[i], i--) {
            B[i] *= cur;
        }
        return B;
    }
}
