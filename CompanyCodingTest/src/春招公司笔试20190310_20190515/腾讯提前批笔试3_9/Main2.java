package 春招公司笔试20190310_20190515.腾讯提前批笔试3_9;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/09 19:38
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N-- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            if (l % 2 == 1 && r % 2 == 0) {//左奇右偶的情况
                System.out.println((r-l+1)/2);
            } else if (l % 2 == 1 && r % 2 == 1) {//左奇右奇的情况
                System.out.println(-(r+l)/2);
            } else if (l % 2 == 0 && r % 2 == 1) {//左偶右奇的情况
                System.out.println(-(r-l+1)/2);
            } else if (l % 2 == 0 && r % 2 == 0) {//左偶右偶的情况
                System.out.println((r+l)/2);

            }
        }
    }
}
