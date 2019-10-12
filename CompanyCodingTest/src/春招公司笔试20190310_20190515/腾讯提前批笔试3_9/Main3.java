package 春招公司笔试20190310_20190515.腾讯提前批笔试3_9;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/09 19:38
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (n < s)
            System.out.println(0);
        else if(n == s)
            System.out.println(1);
        else if(s == 0)
            System.out.println(1<<n);
        else{
            int res = 1;
            res *= (1<<(n-s));
            res *= getMul(n)/getMul(s)/getMul(n-s);
            System.out.println(res%1000000007);
        }
    }
    private static int getMul(int num) {
        if(num == 1 || num == 0)
            return 1;
        else{
            int res = 1;
            while(num > 0){
                res *= num;
                num--;
            }
            return res;
        }


    }
}
