package 秋招公司笔试20190727_20190921.旷视20190909;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/09 21:28
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = 0;
        while (num != 0) {
            cnt++;
            num &= (num - 1);
        }
        System.out.println(cnt);
    }
}
