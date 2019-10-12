package 牛油面试手撕;

import java.util.Arrays;

/**
 * @author tankInternshipInterview
 * @create 2019/08/22 17:27
 */
public class 大数相乘 {
    public static void main(String[] args) {
        System.out.println(multi("9133", "0"));
    }

    private static String multi(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 ) {
            return "";
        }
        if ("0".equals(s1) || "0".equals(s2)) {
            return "0";
        }
        int len1 = s1.length();
        int len2 = s2.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        reverse(chars1);
        reverse(chars2);
        int[] res = new int[len1 + len2];
        int[] carry = new int[len1 + len2];
        for (int i = 0; i < len1; i++) {
            carry = new int[len1 + len2];
            int j;
            for (j = 0; j < len2; j++) {
                int i1 = Integer.valueOf(chars1[i] - '0') * Integer.valueOf(chars2[j] - '0') + carry[i + j];
                carry[i + j + 1] = i1 / 10;// 这一位的进位，给下一位数加
                i1 %= 10;
                int temp = res[i + j] + i1;
                res[i + j] = temp % 10;
                carry[i + j + 1] += temp / 10;
            }
            res[i + j] += carry[i + j];
        }
        if (carry[len1 + len2 - 1] > 0) {
            res[len1 + len2 - 1] = carry[len1 + len2 - 1];
        }
        StringBuilder sb = new StringBuilder();
        if (res[res.length - 1] != 0) {
            sb.append(res[res.length - 1]);
        }
        for (int k = res.length - 2; k >= 0; k--) {
            sb.append(res[k]);
        }
        return sb.toString();
    }

    private static void reverse(char[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i];
            arr[i] = temp;
        }
    }
}
