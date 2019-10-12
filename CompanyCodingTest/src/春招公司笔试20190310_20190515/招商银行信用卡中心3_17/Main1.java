package 春招公司笔试20190310_20190515.招商银行信用卡中心3_17;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/17 19:57
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min1 = sc.nextInt();
        int max1 = sc.nextInt();
        int min2 = sc.nextInt();
        int max2 = sc.nextInt();
        int min3 = sc.nextInt();
        int max3 = sc.nextInt();
        int[] res = new int[3];
        if (n - min1 - min2 - min3 <= max1 - min1) {
            res[0]=n-min2-min3;
            res[1]=min2;
            res[2]=min3;
        }else if(n-max1-min2-min3<=max2-min2){
            res[0]=max1;
            res[1]=n-max1-min3;
            res[2]=min3;
        }else{
            res[0]=max1;
            res[1]=max2;
            res[2]=n-max1-max2;
        }
        System.out.print(res[0]+" ");
        System.out.print(res[1]+" ");
        System.out.println(res[2]);
    }
}
