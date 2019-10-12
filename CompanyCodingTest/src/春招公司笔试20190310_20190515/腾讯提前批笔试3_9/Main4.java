package 春招公司笔试20190310_20190515.腾讯提前批笔试3_9;

/**
 * @author tankInternshipInterview
 * @create 2019/03/09 21:11
 */

import java.util.HashSet;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

//        Scanner input = new Scanner(System.in);
//        int n, q;
//        String str1 = input.nextLine();
//        String arr1[] = str1.split(" ");
//        n = Integer.parseInt(arr1[0]);
//        q = Integer.parseInt(arr1[1]);
//
//        String str = input.nextLine();
//        String arr[] = str.split(" ");
//        int a[] = new int[arr.length];
//        for (int j = 0; j < a.length; j++) {
//            a[j] = Integer.parseInt(arr[j]);
//        }

        System.out.println(minLen(arr, q));
    }
    public static int minLen(int a[], int m) {
        HashSet<Integer> temp = new HashSet<>();
        int minLen = a.length;
        int count = 0;
        boolean flag = false;

        for (int start = 0; start < a.length - m; start++) {
            count = 0;
            temp.clear();
            for (int j = start; j < a.length; j++) {
                if (a[j] == 0) {
                    count++;
                } else {
                    count++;
                    temp.add(a[j]);
                    if (temp.size() == m) {
                        minLen = (count < minLen) ? count : minLen;
                        flag = true;
                    }
                }
            }
        }
        if (flag) {
            return minLen;
        } else
            return -1;
    }
}
