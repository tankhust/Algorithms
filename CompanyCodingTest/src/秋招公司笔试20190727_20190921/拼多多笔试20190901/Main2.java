package 秋招公司笔试20190727_20190921.拼多多笔试20190901;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/01 14:52
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();// cnt表示骰子数量
        int[] res = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            res[i] = sc.nextInt();
        }

    }

    public void sortTeat(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public double calcu(int i, int[] counts) {
        double j = 1;
        int n = counts.length;
        for (int k = 1; k < counts.length; k++) {
            j *= counts[k];
        }
        double rate = (n * calJi(i, n - 1) - n + 1) / j;
        double r = i * rate;
        return r;
    }

    public double calJi(int k, int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= k;
        }
        return res;
    }
}
