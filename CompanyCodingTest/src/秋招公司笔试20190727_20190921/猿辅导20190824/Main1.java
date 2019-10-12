package 秋招公司笔试20190727_20190921.猿辅导20190824;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/08/24 15:56
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 学生报数总个数n
        int m = sc.nextInt();// 允许的最大重复次数m
        int[] arr = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            }
            else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) > m) {
                continue;
            }
            System.out.print(arr[i] + " ");
        }
    }
}
