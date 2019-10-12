package 春招公司笔试20190310_20190515.腾讯正式批笔试4_5;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/04/05 20:35
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        int len = str.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(str.charAt(i) == '1'){
                count ++;
            }
        }
        System.out.println(Math.abs(len - 2*count));
    }
}
