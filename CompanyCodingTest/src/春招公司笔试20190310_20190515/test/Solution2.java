package 春招公司笔试20190310_20190515.test;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/02 16:48
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- != 0) {
            int in = sc.nextInt();
            System.out.println( (in % 5 == 0|| in % 5 == 2) ? "yang" : "niu");
        }
        return;
    }
}
