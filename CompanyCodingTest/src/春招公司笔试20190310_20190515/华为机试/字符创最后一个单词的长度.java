package 春招公司笔试20190310_20190515.华为机试;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/12 12:31
 */
public class 字符创最后一个单词的长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int start = s.length() - 1;
        for (int i = start; i >= 0; i--) {
            if(s.charAt(i) != ' '){
                continue;
            }else{
                start = i;
            }
        }
        System.out.println(s.length() - start - 1);
    }
}
