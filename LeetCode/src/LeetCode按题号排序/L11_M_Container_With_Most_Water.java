package LeetCode按题号排序;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * <p>
 * <p>
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * @author tank
 * @create 2020/02/19 11:15
 */
public class L11_M_Container_With_Most_Water {
    public static void main(String[] args) {
        L11_M_Container_With_Most_Water l11 = new L11_M_Container_With_Most_Water();
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(l11.maxArea(arr));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int len = height.length;
        int l = 0, r = len - 1;
        int max = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                max = Math.max((r - l) * height[l], max);
                l++;
            } else {
                max = Math.max((r - l) * height[r], max);
                r--;
            }
        }
        return max;
    }
}
