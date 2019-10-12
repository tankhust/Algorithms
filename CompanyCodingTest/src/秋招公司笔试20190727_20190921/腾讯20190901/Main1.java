package 秋招公司笔试20190727_20190921.腾讯20190901;

import java.util.Scanner;

/**
 * 宝藏
 * n个宝箱，m个钥匙
 * ai+bj为奇数才能打开
 * 宝箱和钥匙都只能用一次
 * 求最多能打开多少个宝箱
 * @author tankInternshipInterview
 * @create 2019/09/01 19:50
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 宝箱个数
        int m = sc.nextInt();// 钥匙个数
        int[] boxes = new int[n];
        int[] keys = new int[m];
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = sc.nextInt();
        }
        for (int i = 0; i < keys.length; i++) {
            keys[i] = sc.nextInt();
        }
        int boxesOdd = 0, boxesEven = 0;
        int keysOdd = 0, keysEven = 0;
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] % 2 == 0) {
                boxesOdd++;
            }else {
                boxesEven++;
            }
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] % 2 == 0) {
                keysOdd++;
            }else {
                keysEven++;
            }
        }
        int res = Math.min(boxesOdd, keysEven) + Math.min(boxesEven, keysOdd);
        System.out.println(res);
    }
}
