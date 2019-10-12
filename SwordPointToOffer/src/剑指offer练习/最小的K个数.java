package 剑指offer练习;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author tankInternshipInterview
 * @create 2019/07/14 15:46
 */
public class 最小的K个数 {
    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(new 最小的K个数().GetLeastNumbers_Solution(input, 4));
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || input.length < k || k < 1){
            return res;
        }
        findKthSmallest(input, k);
        for(int i = 0; i < k; i++){
            res.add(input[i]);
        }
        return res;
    }
    private void findKthSmallest(int[] input, int k){
        int l = 0, h = input.length - 1;
        while(l <= h){
            int j = partition(input, l, h);
            if(j == k){
                return;
            }
            if(j > k){
                h = j - 1;
            }else{
                l = j + 1;
            }
        }
    }
    private int partition(int[] input, int l, int h){
        int p = input[l];
        int i = 0, j = h + 1;
        while(true){
            while(i != h && input[++i] < p);
            while(j != l && input[--j] > p);
            if(i >= j)
                break;
            swap(input, i, j);
        }
        swap(input, l, j);
        return j;
    }
    private void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
