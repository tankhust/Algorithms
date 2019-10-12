package 秋招公司笔试20190727_20190921.网易互娱20190907;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/07 19:04
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (isPalindrome(getBinaryString(arr[i]))) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static String getBinaryString(int num) {
        String a = "";
        while (num != 0) {
            a = num % 2 + a;
            num /= 2;
        }
        return a;
    }

    private static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
