package 秋招公司笔试20190727_20190921.VIPKID20190903;

import java.util.*;

/**
 * 寻找zero 组数
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 给定一个整数的数组，找出其中的pair(a,  b)，使得a+b=0，并返回这样的pair数目。（a,  b）和(b,  a)是同一组。
 *
 * 输入
 *  整数数组
 *
 * 输出
 * 找到的pair数目
 *
 *
 * 样例输入
 * -1,  2,   4,  5,  -2
 * 样例输出
 * 1
 * @author tankInternshipInterview
 * @create 2019/09/03 16:41
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll(" ", "");
        String[] split = str.trim().split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.valueOf(split[i]);
        }
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        int cnt = 0;
        while (i <= j) {
            if (arr[i] + arr[j] > 0) {
                j--;
            } else if (arr[i] + arr[j] < 0) {
                i++;
            }else{
                cnt++;
                i++;
                j--;
            }
        }
        System.out.println(cnt);
    }
}
