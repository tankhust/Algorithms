package 秋招公司笔试20190727_20190921.拼多多笔试20190901;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/01 14:52
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        while (S > 0) {
            S--;
            String str1 = sc.next();
            String str2 = sc.next();
            String[] s1 = str1.split(" ");
            List<Integer> list1 = new ArrayList<>();
            for (String s : s1) {
                list1.add(Integer.valueOf(s));
            }
            String[] s2 = str2.split(" ");
            List<Integer> list2 = new ArrayList<>();
            for (String s : s2) {
                list2.add(Integer.valueOf(s));
            }
            if (list1.containsAll(list2)) {

            }else {
                System.out.println("{");
                System.out.println("}");
            }
        }
    }
}
