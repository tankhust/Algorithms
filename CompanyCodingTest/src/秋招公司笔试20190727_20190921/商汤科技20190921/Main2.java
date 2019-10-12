package 秋招公司笔试20190727_20190921.商汤科技20190921;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/21 19:41
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int curMax = -20005, sumMax= -20005;
        int curMin = 20005, sumMin= 20005;
        int sum = 0;
        for (int i : arr) {
            curMax = Math.max(curMax + i, i);
            sumMax = Math.max(curMax, sumMax);
            curMin = Math.min(curMin + i, i);
            sumMin = Math.min(curMin, sumMin);
            sum += i;
        }
        boolean hasPositive = false;
        int max = -20005;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                max = Math.max(max, arr[i]);
                continue;
            }
            hasPositive = true;
        }
        // 当最大连续段经过首尾时，用总和-最小连续子数组即可得结果
        // 全为负数时，最大的负数即为结果
        System.out.println(hasPositive ? Math.max(sumMax, sum - sumMin) : max);
    }
}
