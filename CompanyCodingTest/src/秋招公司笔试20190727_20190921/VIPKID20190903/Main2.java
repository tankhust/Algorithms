package 秋招公司笔试20190727_20190921.VIPKID20190903;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/03 16:41
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = (n - 1) & n;
        }
        System.out.println(cnt);
    }
}
