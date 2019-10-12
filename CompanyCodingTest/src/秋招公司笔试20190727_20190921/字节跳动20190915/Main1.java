package 秋招公司笔试20190727_20190921.字节跳动20190915;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/15 16:07
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1;
            int r = arr.length - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum < k) {
                    res = res + r - l;
                    l++;
                }else{
                    r--;
                }
            }
        }
        System.out.println(res);
    }
}
