package 春招公司笔试20190310_20190515.字节跳动4_14笔试题;

/**
 * @author tankInternshipInterview
 * @create 2019/04/14 11:04
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main5 {

    public static int[] a = new int[1024];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while ((n--) != 0) {
            int m = in.nextInt();
            for (int i = 0; i < m; i++)
                a[i] = in.nextInt();

            Arrays.sort(a, 0, m);

            int i;
            int ans = 0;
            for (i = m; i >= 4; i -= 2) {
                //最快和最慢过去，然后最快回来，在和次慢过去，最快回来
                int temp1 = a[i - 1] + a[0] + a[i - 2] + a[0];

                //最快和次慢过去，然后最快回来，在次慢和最慢过去，次慢回来
                int temp2 = a[1] + a[0] + a[i - 1] + a[1];
                ans = ans + ((temp1 < temp2) ? temp1 : temp2);
            }
            if (i == 3)
                ans += a[0] + a[1] + a[2];
            if (i == 2)
                ans += a[1];
            if (i == 1)
                ans += a[0];
            System.out.println(ans);
        }

    }
}
