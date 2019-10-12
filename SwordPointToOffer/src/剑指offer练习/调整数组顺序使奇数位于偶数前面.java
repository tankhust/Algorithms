package 剑指offer练习;

import java.util.Arrays;

/**
 * @author tankInternshipInterview
 * @create 2019/07/10 23:54
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int[] res = new 调整数组顺序使奇数位于偶数前面().Solution(nums);
        System.out.println(Arrays.toString(res));
    }
    public int[] Solution(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;
        int oddNum = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] % 2 == 1) {
                oddNum++;
            }
        }
        int[] copy = nums.clone();
        int i = 0, j = oddNum;
        for (int num : copy) {
            if(num % 2 == 1)
                nums[i++] = num;
            else
                nums[j++] = num;
        }
        return nums;
    }

}
