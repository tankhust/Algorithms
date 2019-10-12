package 秋招公司笔试20190727_20190921.小红书20190818;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/08/18 15:45
 */
public class 字符串倒序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        String res = "";
        for (int i = s.length - 1; i >= 0; i--) {
            if ("".equals(s[i])) {
                continue;
            }
            res += s[i] + " ";
        }
        System.out.println(res);
    }
}
