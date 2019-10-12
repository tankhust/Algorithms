package 春招公司笔试20190310_20190515.拼多多提前批笔试3_10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/10 16:27
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        bank[] bank = new bank[n];
        for (int i = 0; i < n; i++) {
            bank[i] = new bank(sc.nextInt(), sc.nextInt());
        }
//        Arrays.sort(bank, new Comparator<bank>() {
//            @Override
//            public int compare(bank o1, bank o2) {
//                return o1.a - o2.a;
//            }
//        });
        Arrays.sort(bank,((o1, o2) -> o1.a - o2.a));//根据银行坐标排序
        int r = 0, l = 0, ans = 0, maxLeftPart = 0;
        while (r < n) {
            while (bank[l].a + d < bank[r].a) {//当左银行和右银行的距离超过d时，循环更新左银行的最大值，并将左银行右移
                if (bank[l].b > maxLeftPart)
                    maxLeftPart = bank[l].b;
                l++;
            }
            if (bank[r].b + maxLeftPart > ans)//更新右银行+左银行的总金额的最大值，并将右银行右移
                ans = bank[r].b + maxLeftPart;
            r++;
        }

        System.out.println(ans);

    }

    public static class bank {
        int a;//坐标
        int b;//金额

        public bank(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
