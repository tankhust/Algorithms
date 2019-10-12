package 秋招公司笔试20190727_20190921.快手20190825;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author tankInternshipInterview
 * @create 2019/08/25 16:25
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] res = new boolean[n];
        int a = 0;
        while (n > 0) {
            n--;
            String str = sc.next();
            res[a] = false;
            Set<String> set = new HashSet<>();
            while (!set.contains(str)) {
                set.add(str);
                char[] chars = str.toCharArray();
                int temp = 0;
                for (int i = 0; i < chars.length; i++) {
                    temp += (chars[i] - '0') * (chars[i] - '0');
                }
                if (temp == 1) {
                    res[a] = true;
                    break;
                } else {
                    str = String.valueOf(temp);
                }
            }
            a++;
        }
        for (int i = 0; i < a; i++) {
            System.out.println(res[i]);
        }
    }

}
