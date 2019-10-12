package 秋招公司笔试20190727_20190921.贝壳找房20190810;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 月光宝盒的密码
 *
 * 题目描述：
 * 小希偶然得到了传说中的月光宝盒,然而打开月光宝盒需要一串密码。虽然小希并不知道密码具体是什么，但是月光宝盒的说明书上有着一个长度为 n (2 <= N <= 50000)的序列 a (-10^9 <= a[i] <= 10^9)的范围内。下面写着一段话：密码是这个序列的最长的严格上升子序列的长度(严格上升子序列是指，子序列的元素是严格递增的，例如: [5,1,6,2,4]的最长严格上升子序列为[1,2,4])，请你帮小希找到这个密码。
 *
 *
 * 输入
 * 第1行：1个数N，N为序列的长度(2<=N<=50000)
 *
 * 第2到 N+1行：每行1个数，对应序列的元素(-10^9 <= a[i] <= 10^9)
 *
 * 输出
 * 一个正整数表示严格最长上升子序列的长度
 *
 *
 * 样例输入
 * 8
 * 5
 * 1
 * 6
 * 8
 * 2
 * 4
 * 5
 * 10
 * 样例输出
 * 5
 * @author tankInternshipInterview
 * @create 2019/08/10 18:55
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[n];// dp[i]表示长度为i+1的最长上升子序列的最小值
        Arrays.fill(dp,Integer.MAX_VALUE);
        int pos = 0;
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[pos]) {
                dp[++pos] = nums[i];// nums[i]比dp[pos]大，直接把nums[i]添加到dp尾
            }else{
                // 二分法找出第一个大于或等于nums[i]的位置，并用nums[i]替换
                dp[binarySearch(dp, 0, pos, nums[i])] = nums[i];
            }
        }
        System.out.println(pos + 1);

    }

    private static int binarySearch(int[] dp, int l, int r, int target) {
        while (l < r) {
            int mid = l + ((r - l)>> 1);

                if (dp[mid] >= target) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
