package 春招公司笔试20190310_20190515.腾讯提前批笔试3_9;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/09 19:38
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int cnt = 0;
        while(M != 0){
            if(N < M){
                M -= N;
                cnt ++;
            }else{
                N--;
            }
        }
        System.out.println(cnt);
    }
}
