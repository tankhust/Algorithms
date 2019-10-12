package 春招公司笔试20190310_20190515.拼多多提前批笔试3_10;

import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = str.toLowerCase();
        int[] count = new int[30];
        int len = s.length();
        for (int i = 0; i < len; i++)
            count[s.charAt(i)-'a']++;
        char res = 'z';
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) < res) res = s.charAt(i);//更新当前最小值
            count[s.charAt(i)-'a']--;
            if (count[s.charAt(i)-'a'] == 0) break;//找到第一个只出现一次的字符就可以得到最终结果
        }
        System.out.println(res);
    }
}
