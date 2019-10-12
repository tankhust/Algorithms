package 秋招公司笔试20190727_20190921.pdd20190925;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/25 16:00
 */
public class Main3_1 {
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        String res = "";
        solution(n, m, k, res);
        System.out.println(res);
    }

    private static boolean solution(int n, int m, int k, String res) {
//        if (n == 0 && m == 0) {
            if (cnt == k) {
                return true;
            }else{
                cnt++;
            }
//        }
        if (n > 0) {
            res += 'a';
            if (solution(n - 1, m, k,res)) {
                return true;
            }else{
                res = res.substring(0, res.length() - 1);
            }
        }
        if (m > 0) {
            res += 'b';
            if (solution(n, m - 1, k,res)) {
                return true;
            }else{
                res = res.substring(0, res.length() - 1);
            }
        }
        return false;
    }
}
