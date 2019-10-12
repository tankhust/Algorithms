package 秋招公司笔试20190727_20190921.商汤科技20190921;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/21 19:58
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int maxJinzhi = 10;
        int[] nums = new int[20];
        for (int jinzhi = 10; jinzhi < n; jinzhi++) {
            int index = 0;
            int tmp = n;
            while (tmp != 0) {
                int remain = tmp % jinzhi;
                tmp = tmp / jinzhi;
                nums[index++] = remain;
            }
            // nums为由十进制转换为i进制后的数组
            if (isValid(nums, x)) {
                maxJinzhi = Math.max(maxJinzhi, jinzhi);
            }
        }
        System.out.println(maxJinzhi);
    }

    private static boolean isValid(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 9) {
                return false;
            }
        }
        String temp = "";
        for (int i = nums.length - 1; i >= 0; i--) {
            temp += String.valueOf(nums[i]);
        }
        if (Integer.valueOf(temp) >= x) {
            return true;
        }
        return false;
    }
}
