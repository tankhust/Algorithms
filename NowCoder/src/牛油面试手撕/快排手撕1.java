package 牛油面试手撕;

/**
 * @author tankInternshipInterview
 * @create 2019/08/08 08:48
 */
public class 快排手撕1 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 6, 3, 8};
        new 快排手撕1().quickSort(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }
    public void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = partition(arr, start, end);
        quickSort(arr,start, i - 1);
        quickSort(arr, i + 1, end);
    }

    public int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            arr[l] = arr[r];
            while(l < r && arr[l] <= pivot){
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }
}
