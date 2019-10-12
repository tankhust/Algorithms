package 春招公司笔试20190310_20190515.华为机试;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/12 16:19
 */
public class 字符串分隔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            int len1 = s1.length();
            int i = 0;
            for(i = 0; i + 8 <= len1; i+=8){
                System.out.println(s1.substring(i, i+8));
            }
            System.out.print(s1.substring(i));
            for(int j = 0; j < 8 - (len1 - i); j++){
                System.out.print(0);
            }
            System.out.println();
        }

    }
}
