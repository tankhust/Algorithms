package 秋招公司笔试20190727_20190921.猿辅导20190824;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/08/24 15:56
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();// 测试用量
        int[] res = new int[c];
        int n = 0;
        while (c-- > 0) {
            int t = sc.nextInt();// 可供选择的角色数量T
            Integer[] p = new Integer[t];
            for (int i = 0; i < p.length; i++) {
                p[i] = sc.nextInt();
            }
            Arrays.sort(p, Collections.reverseOrder());
            int temp1 = p[0];
            int temp2 = p[1];
            int temp3 = p[2];
            temp1 -= temp3;
            temp2 -= temp3;
            res[n] = temp3; // 最大的对话小组数量
            temp3 = 0;
            for (int i = 3; i < p.length; i++) {
                int min = Math.min(temp1, Math.min(temp2, temp3));
                temp1 -= min;
                temp2 -= min;
                temp3 = p[i];
                if (temp3 > temp1) {// temp3是最大的
                    int temp = temp3;
                    temp3 = temp2;
                    temp2 = temp1;
                    temp1 = temp;
                }else if(temp3 > temp2){
                    int temp = temp3;
                    temp3 = temp2;
                    temp2 = temp;
                }
                res[n]+=min;
            }
            n++;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }
}
