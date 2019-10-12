package 剑指offer练习;

import java.util.ArrayList;

/**
 * @author tankInternshipInterview
 * @create 2019/08/11 09:45
 */
public class 最小的k个数2 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(new 最小的k个数2().FindKthSmallest(arr, 4));
    }

    public ArrayList<Integer> FindKthSmallest(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (arr == null || arr.length < k || k <= 0)
            return res;
        getKthSmallest(arr, k, res);
        for (int i = 0; i < k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public void getKthSmallest(int[] arr, int k, ArrayList<Integer> res) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int p = partition(arr, l, r);
            if (p == k) {
                return;
            } else if (p < k) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }
}
