package 春招公司笔试20190310_20190515.华为机试;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/03/12 15:50
 */
public class 明明的随机数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //确定范围内的数字排序都可以用这种方法
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[1000];
            while(n-- > 0) {
                arr[sc.nextInt()] = 1;
            }
            for(int i = 0; i < 1000; i++){
                if(arr[i] == 1)
                    System.out.println(i);
            }
        }
    }
}
