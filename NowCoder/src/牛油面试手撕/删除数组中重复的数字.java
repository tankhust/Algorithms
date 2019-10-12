package 牛油面试手撕;

import java.util.Arrays;

/**
 * @author tankInternshipInterview
 * @create 2019/09/16 22:57
 */
public class 删除数组中重复的数字 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 3, 3, 4, 4, 4, 5};
        int i = 0, j = 0;
        int numOfDup = 0;
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                j++;
            }else {
                if (j - i > 1) {
                    //说明i ~ j - 1之间出现了重复的数字
                    for (int k = i; k < j; k++) {
                        arr[k] = -1;
                        numOfDup ++;
                    }
                }
                // 用于下一次遍历
                i = j;
                j++;
            }
        }
        int[] res = new int[arr.length - numOfDup];
        int q = 0;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] != -1) {
                res[q++] = arr[k];
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
