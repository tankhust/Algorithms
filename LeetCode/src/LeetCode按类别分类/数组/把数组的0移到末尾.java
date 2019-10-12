package LeetCode按类别分类.数组;

import java.util.Arrays;

/**
 * @author tankInternshipInterview
 * @create 2019/08/20 16:55
 */
public class 把数组的0移到末尾 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 4};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeros(int[] arr) {
        int idx = 0;
        for (int i : arr) {
            if (i != 0) {
                arr[idx++] = i;
            }
        }
        for (int i = idx; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
