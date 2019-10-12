package 秋招公司笔试20190727_20190921.zoom20190817;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/08/17 14:36
 */
public class 求连续子数组的最大乘积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String[] split = next.split(",");
        double[] arr = new double[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.valueOf(split[i]);
        }
        double res = arr[0];
        double curMax = arr[0], curMin = arr[0];
        double lastMax = arr[0], lastMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curMax = Math.max(arr[i], Math.max(lastMax * arr[i], lastMin * arr[i]));
            curMin = Math.min(arr[i], Math.min(lastMax * arr[i], lastMin * arr[i]));
            res = Math.max(res, curMax);
            lastMax = curMax;
            lastMin = curMin;
        }
        System.out.println(res);
    }
}
