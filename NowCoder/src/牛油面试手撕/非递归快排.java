package 牛油面试手撕;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author tankInternshipInterview
 * @create 2019/07/27 11:16
 */
public class 非递归快排
{
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 1, 9, 2};
        int[] arr2 = {4, 3, 2, 1, 9, 2};
        int[] res = new 非递归快排().iterativeQuickSort(arr);
        printArr(res);

    }

    private int[] iterativeQuickSort(int[] arr) {
        if(arr == null || arr.length < 2)
            return arr;
        Stack<Integer> stack = new Stack<>();
        int start = 0, end = arr.length - 1;
        if (start < end) {
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(arr, l, r);
                if(l < index - 1){
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
        return arr;
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        // 必须先遍历右边的
        while (l < r) {
            while(l < r && arr[r] >= pivot)
                r--;
            arr[l] = arr[r];
            while(l < r && arr[l] <= pivot)
                l++;
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
