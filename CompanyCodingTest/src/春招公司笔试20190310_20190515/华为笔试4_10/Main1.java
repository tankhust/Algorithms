package 春招公司笔试20190310_20190515.华为笔试4_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/04/10 19:04
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = new String[N];
        List<String> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            str[i] = sc.next();
        }
        for(int i = 0; i < N; i++){
            if(str[i].length() == 8){
                list.add(str[i]);
            } else if (str[i].length() < 8) {
                int zeroCount = 8 - str[i].length();
                String temp = str[i];
                while (zeroCount-- > 0) {
                    temp += "0";
                }
                list.add(temp);
            } else {
                String temp = str[i];
                while(temp.length() > 8){
                    String temp1 = temp.substring(0,8);
                    list.add(temp1);
                    temp = temp.substring(8);
                }
                int zeroCount = 8 - temp.length();
                while (zeroCount-- > 0) {
                    temp += "0";
                }
                list.add(temp);
            }
        }
        Collections.sort(list);
        for(String s : list){
            System.out.print(s);
            System.out.print(" ");
        }
    }

}
