package LeetCode按类别分类.数组;

/**
 * @author tankInternshipInterview
 * @create 2019/08/20 17:53
 */
public class 查找数组中乘积最大的三个数
{
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, -4};
        System.out.println(maxProduct(arr));
    }

    private static int maxProduct(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }

            if (i < min1) {
                min2 = min1;
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
