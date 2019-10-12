package 秋招公司笔试20190727_20190921.五八同城20190912;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/12 20:39
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] cookies = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                cookies[0] = 1;
                continue;
            }
            if (arr[i] > arr[i - 1]) {
                cookies[i] = cookies[i - 1] + 1;
            }else{
                cookies[i] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += cookies[i];
        }
        System.out.println(res);
    }
}
