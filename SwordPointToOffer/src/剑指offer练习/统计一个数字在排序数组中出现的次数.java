package 剑指offer练习;

/**
 * @author tankInternshipInterview
 * @create 2019/07/14 22:09
 */
public class 统计一个数字在排序数组中出现的次数 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4, 6, 7};
        System.out.println(new 统计一个数字在排序数组中出现的次数().GetNumOfK(nums, 3));
    }
    public int GetNumOfK(int[] nums, int k){
        int first = getFirstOfNum(nums, k);
        int last = getFirstOfNum(nums, k + 1);
        return (first == nums.length || nums[first] != k) ? 0 : last - first;
    }
    private int getFirstOfNum(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + ((h - l) >> 1);
            if(nums[mid] >= k){
                h = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
