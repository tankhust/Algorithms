package LeetCode按类别分类;

/**
 * @author tankInternshipInterview
 * @create 2019/08/23 14:23
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int l = 0;
        int r = arr.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(arr[l], arr[r]));
            if (arr[l] < arr[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
