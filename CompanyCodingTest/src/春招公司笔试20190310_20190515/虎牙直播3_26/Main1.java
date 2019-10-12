package 春招公司笔试20190310_20190515.虎牙直播3_26;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/26 20:05
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int level = num/2 + 1;
        for(int i = 0; i < level ; i ++){
            print(num - 2*i,i);
        }
    }
    private static void print(int n, int m){
        int m1 = m;
        while(m1-- > 0){
            System.out.print(" ");
        }
        while(n-- > 0){
            System.out.print("*");
        }
        while(m-- > 0){
            System.out.print(" ");
        }
        System.out.println();
    }
}
