package 春招公司笔试20190310_20190515.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tankInternshipInterview
 * @create 2019/02/27 21:37
 */
public class test {
     public static void main(String[] args) {
         List<String> a = new ArrayList<>();
         a.add("1");
         a.add("2");
         for (String temp :
                 a) {
             if ("2".equals(temp)) {
                 a.remove(temp);
             }
         }
         System.out.println(a);
     }
}
