package 秋招公司笔试20190727_20190921.腾讯20190901;

import java.util.Scanner;

/**
 * 期末总结
 *
 * @author tankInternshipInterview
 * @create 2019/09/01 19:50
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();// 学习天数
        int[] scores = new int[days];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = sc.nextInt();
        }
//        int i = 0, j = 0;
        int max = 1;
        for (int i = 0; i < scores.length; i++) {
            for (int j = i; j < scores.length; j++) {
                int tempStart = i;
                int sum = 0;
                int min = scores[tempStart];
                while (tempStart <= j) {
                    sum = sum + scores[tempStart];
                    min = Math.min(min, scores[tempStart]);
                    tempStart++;
                }
                int temp = sum * min;
                max = Math.max(max, temp);
            }
        }
        System.out.println(max);
    }
}
