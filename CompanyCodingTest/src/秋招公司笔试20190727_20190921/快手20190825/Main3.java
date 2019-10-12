package 秋招公司笔试20190727_20190921.快手20190825;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/08/25 16:25
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] s1 = str1.split(" ");
        String[] s2 = str2.split(" ");
        List<String> res = new ArrayList<>();
        int i = 0, j = 0;
        for (; i < s1.length && j < s2.length; i++) {
            if (i != 0 && i % 4 == 0) {
                res.add(s2[j]);
                j++;
            }
            res.add(s1[i]);
        }
        if (j == s2.length && i != s1.length) {
            while (i < s1.length) {
                res.add(s1[i]);
                i++;
            }
        }else if (j != s2.length && i == s1.length){
            while (j < s2.length) {
                res.add(s2[j]);
                j++;
            }
        }
        for (int k = 0; k < res.size(); k++) {
            System.out.print(res.get(k) + " ");
        }
    }
}
