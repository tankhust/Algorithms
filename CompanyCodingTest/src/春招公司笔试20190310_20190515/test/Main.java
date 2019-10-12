package 春招公司笔试20190310_20190515.test;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/07 20:15
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] tao = new int[N];
        for(int i = 0; i < N; i++){
            tao[i] = sc.nextInt();
        }
        Arrays.sort(tao);
        int res = 0;
        //（N-M）对同桌
        for(int i = 0; i < (N-M); i++){
            res = Math.max(res, tao[i]+tao[2*(N-M)-i-1]);
        }
        System.out.println(res);
    }
}
