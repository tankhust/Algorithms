package 春招公司笔试20190310_20190515.携程4_8;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/04/08 20:07
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] str = s.split(",");
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length; i++){
            if(!map.containsKey(str[i])){
                map.put(str[i], 1);
            }else{
                map.put(str[i], map.get(str[i]) + 1);
            }
        }
        boolean hasCircle = false;
        for(String strr : map.keySet()){
            if(map.get(strr) > 1){
                hasCircle = true;
            }
        }
        System.out.println(hasCircle ? true : false);
    }
}
