package 春招公司笔试20190310_20190515.拼多多提前批笔试3_10;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/10 16:27
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println(min(n, arr1, arr2));
    }
    public static int min(int n, int []a , int []b ) {
        int []c = new int[n];
        for(int i= 0 ; i < n ; i ++) {
            c[i] = b[i];
        }
        sort(a);
        sort(c);
        int result = 0;
        for(int i = 0 ,j = n-1 ; i < n ; i ++) {
            result += (a[i]*c[j--]);
        }
        return result;
    }
    public static void sort(int [] nums) {
        if(nums == null) {
            return;
        }
        for(int i = 0 ; i < nums.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

    }
}
