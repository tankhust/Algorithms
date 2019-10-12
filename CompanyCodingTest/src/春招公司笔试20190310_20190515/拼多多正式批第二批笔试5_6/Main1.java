package 春招公司笔试20190310_20190515.拼多多正式批第二批笔试5_6;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/05/06 18:47
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int count = 0;
        while(i < sb.length()){
            while(i >= 1 && i < sb.length() && sb.charAt(i) == sb.charAt(i - 1)){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i - 1);
                count ++;
                i--;
            }
            i++;
        }
        System.out.println(count);
    }
}
