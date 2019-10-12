package 秋招公司笔试20190727_20190921.爱奇艺20190908;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 排列计数
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 给定一个长度为N-1且只包含0和1的序列A1到AN-1，如果一个1到N的排列P1到PN满足对于1≤i<N，当Ai=0时Pi<Pi+1，当Ai=1时Pi>Pi+1，则称该排列符合要求，那么有多少个符合要求的排列？
 *
 * 输入
 * 第一行包含一个整数N，1<N≤1000。
 *
 * 第二行包含N-1个空格隔开的整数A1到AN-1，0≤Ai≤1
 *
 * 输出
 * 输出符合要求的排列个数对109+7取模后的结果。
 *
 *
 * 样例输入
 * 4
 * 1 1 0
 * 样例输出
 * 3
 *
 * 提示
 * 样例解释
 *
 * 符合要求的排列为{3 2 1 4}、{4 2 1 3}和{4 3 1 2}。
 * @author tankInternshipInterview
 * @create 2019/09/08 15:46
 */
public class Main1 {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n - 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        permutation(list, 0);
        int num = isValid(res, arr);
        System.out.println(num);
    }

    private static int isValid(List<List<Integer>> res, int[] arr) {
        int cnt = 0;
        for (List<Integer> re : res) {
            Integer[] tempArr = re.toArray(new Integer[re.size()]);
            boolean valid = true;
            int i = 0;
            while (i < tempArr.length - 1) {
                if (arr[i] == 1) {
                    if (tempArr[i] <= tempArr[i + 1]) {
                        valid = false;
                        break;
                    }
                }
                if (arr[i] == 0) {
                    if (tempArr[i] >= tempArr[i + 1]) {
                        valid = false;
                        break;
                    }
                }
                i++;
            }
            if (valid) {
                cnt++;
            }
        }
        return cnt;
    }

    private static List<List<Integer>> permutation(List<Integer> list, int index) {
        if (index >= list.size()) {
            res.add(new ArrayList<>(list));
            return res;
        }
        for (int i = index; i < list.size(); i++) {
            swap(list, i, index);
            permutation(list,index + 1);
            swap(list, i, index);
        }
        return res;
    }

    private static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
