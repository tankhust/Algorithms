package 春招公司笔试20190310_20190515.腾讯正式批笔试4_5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/04/05 20:35
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aimMoney = sc.nextInt();//硬币的面值
        int coinKinds = sc.nextInt();//硬币的种类
        int[] values = new int[coinKinds];
        for(int i = 0; i < coinKinds; i++){
            values[i] = sc.nextInt();
        }
        Arrays.sort(values);

        int[][] count = new int[coinKinds + 1][aimMoney + 1];
        for(int i = 0; i <= coinKinds; i++){
            count[i][0] = 0;//硬币面值为0时，最少需要携M带的硬币数为0;
        }
        for(int i = 0; i <= aimMoney; i++){
            count[0][i] = Integer.MAX_VALUE;//硬币种类为0时，最少需要携带的硬币数为无穷大;
        }
        for (int j = 1; j <= aimMoney; j++) {//硬币的面值
            for (int i = 1; i <= coinKinds; i++) {//硬币的种类
                if(j < values[i - 1]) {//value数组的下标从0开始,目标面值小于当前硬币面值
                    count[i][j] = count[i -1][j];
                    continue;
                }

                count[i][j] = Math.min(count[i - 1][j], count[i][j - values[i - 1]] + 1);
            }
        }
        if(values[0] != 1)
            System.out.println(-1);
        else
            System.out.println(count[coinKinds][aimMoney]);//面值为0 ~ M, 硬币种类为N时所需要的硬币数
    }
}
