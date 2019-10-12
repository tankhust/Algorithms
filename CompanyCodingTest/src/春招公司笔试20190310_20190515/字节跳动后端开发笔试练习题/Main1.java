package 春招公司笔试20190310_20190515.字节跳动后端开发笔试练习题;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/04/11 21:12
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] like = new int[n];
        for(int i = 0; i < n; i ++){
            like[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[] l = new int[q];
        int[] r = new int[q];
        int[] k = new int[q];
        for(int i = 0; i < q; i ++){
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
            k[i] = sc.nextInt();
        }
        int[] res = new int[q];
        for(int i = 0; i < q; i ++){
            for(int j = l[i] - 1; j <= r[i] - 1; j ++){
                if(k[i] == like[j]){
                    res[i] ++;
                }
            }
        }
        for(int i = 0; i < q; i ++){
            System.out.println(res[i]);
        }
    }
}
