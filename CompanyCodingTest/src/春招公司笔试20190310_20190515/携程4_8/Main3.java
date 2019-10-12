package 春招公司笔试20190310_20190515.携程4_8;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/04/08 20:33
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        if(s == null || k <= 1){
            System.out.println(s);
        }else{
            s = s.substring(1,s.length() - 1);
            int[] arr = new int[s.length() / 2 + 1];
            for(int i = 0; i < arr.length; i++){
                arr[i] = Integer.valueOf(s.substring(2 * i, 2 * i + 1));
            }
            for(int i = 0, j = k - 1; j < arr.length; i += k, j += k){
                int start = i, end = j;
                while(start < end){
                    swap(arr, start, end);
                    start++;
                    end--;
                }
            }
            System.out.print("[");
            for(int i = 0; i < arr.length - 1; i++){
                System.out.print(arr[i] + ",");
            }
            System.out.print(arr[arr.length - 1]);
            System.out.println("]");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
