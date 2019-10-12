package LeetCode按类别分类.数组;

/**
 * @author tankInternshipInterview
 * @create 2019/08/20 17:14
 */
public class 有序数组的KthElement {
    public static void main(String[] args) {
        int[][] arr = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(findKthElement(arr, 8));
    }

    private static int findKthElement(int[][] arr, int k) {
        int m = arr.length, n = arr[0].length;
        int lo = arr[0][0], hi = arr[m - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && arr[i][j] <= mid; j++) {
                    count++;
                }
            }
            if (count < k) {
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return lo;
    }
}
