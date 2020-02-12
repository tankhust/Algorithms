package LeetCode按题号排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tank
 * @create 2019/10/19 16:59
 */
public class L1_L_Two_Sum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        L1_L_Two_Sum l1_L_Two_Sum = new L1_L_Two_Sum();
        int[] res = l1_L_Two_Sum.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return nums;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
