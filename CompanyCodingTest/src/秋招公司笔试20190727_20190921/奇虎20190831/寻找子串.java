package 秋招公司笔试20190727_20190921.奇虎20190831;

import java.util.Scanner;

/**
 * 寻找子串
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 英语老师看你老是在英语课上和周围同学交头接耳，所以给你布置了一份额外的家庭作业来惩罚惩罚你：你有一个字符串s，请你在s的所有子串中，找到出现次数最多的子串，告诉老师它的出现次数。
 *
 * 输入
 * 共一行，一个字符串s，仅由英文小写字母组成，1≤|s|≤10000。
 *
 * 输出
 * 一个正整数，表示最大出现次数。
 *
 *
 * 样例输入
 * aba
 * 样例输出
 * 2
 *
 * 提示
 * aba的所有子串为a、b、a、ab、ba、aba，其中a的出现次数最多，出现了2次。
 * @author tankInternshipInterview
 * @create 2019/08/31 17:11
 */
public class 寻找子串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int max = 0;
        int[] arr = new int[256];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
            if (max < arr[str.charAt(i)]) {
                max = arr[str.charAt(i)];
            }
        }
        System.out.println(max);
    }
//        int maxCnt = 1;
//        String longest = "";
//        int len = str.length();
//        for (int i = 1; i < len / 2; i++) {
//            for (int j = 0; j < len - i - 1; j++) {
//                int cnt = 1;
//                for (int k = j + 2; k < len -i - 1; k++) {
//                    if (str.substring(j, j + i + 1).equals(str.substring(k, k + i + 1))) {
//                        cnt++;
//                    }
//                }
//                if (cnt >= maxCnt) {
//                    maxCnt = cnt;
//                    longest = str.substring(j, j + i + 1);
//                }
//            }
//        }
//        System.out.println(longest);
//        System.out.println(maxCnt);
//    }
}
