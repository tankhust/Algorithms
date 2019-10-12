package 秋招公司笔试20190727_20190921.腾讯20190901;

import java.util.Scanner;

/**
 * 花匠小Q
 *
 * @author tankInternshipInterview
 * @create 2019/09/01 19:50
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        while (t-- > 0) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            int cnt = 0;
            for (int i = left; i <= right; i++) {
                cnt += caculate(i, k, k);
            }
            System.out.println(cnt % (1000000000 + 7));
        }
    }

    private static int caculate(int length, int nk, int k) {
        if (nk == 0 || nk > length) {
            return 1;
        }
        int sum = length - nk + 1 + caculate(length, nk + k, k);
        return sum;
    }
}
