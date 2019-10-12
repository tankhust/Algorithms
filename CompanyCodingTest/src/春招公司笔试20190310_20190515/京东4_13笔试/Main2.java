package 春招公司笔试20190310_20190515.京东4_13笔试;

import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/04/13 19:51
 */
public class Main2 {
//    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] strr = new String[m];//子串
        for (int i = 0; i < m; i++) {
            strr[i] = sc.next();
        }
        String strT = sc.next();//字符串T
        boolean[] charUsed = new boolean[strT.length()];
        int[] usedTimes = new int[m];
        boolean[] strrUsed= new boolean[m];
    }


    private boolean hasUsed(String strr, int index, boolean[] charUsed) {
        for(int i = index; i < index + strr.length(); i++){
            if(charUsed[i]){
                return true;
            }
        }
        return false;
    }

}
