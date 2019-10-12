package 秋招公司笔试20190727_20190921.旷视20190909;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/09 21:30
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String str = sc.next();
        int res = 0;
        int l = 0;
        int r = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r < str.length()){
            map.put(str.charAt(r), r);
            while (map.size() > k) {
                char lChar = str.charAt(l);
                if (map.get(lChar) == l) {
                    map.remove(lChar);
                }
                l++;
            }
            int temp = r - l + 1;
            res = Math.max(res, temp);
            r++;
        }
        System.out.println(res);
    }
}
