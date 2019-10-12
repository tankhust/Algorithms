package 剑指offer练习;

import java.util.Arrays;

/**
 * @author tankInternshipInterview
 * @create 2019/07/14 16:45
 */
public class 把数组排成最小的数 {
    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        System.out.println(new 把数组排成最小的数().PrintMinNumber(numbers));
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String res = "";
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }
}
