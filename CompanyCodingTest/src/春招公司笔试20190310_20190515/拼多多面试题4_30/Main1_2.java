package 春招公司笔试20190310_20190515.拼多多面试题4_30;

import java.util.Scanner;

/**
 * 大神给的思路，复杂度O(n²)
 * @author tankInternshipInterview
 * @create 2019/05/06 22:32
 */
public class Main1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String tmp0 = "";
        String tmp = "";
        double res = 0;
        str += "#";//设置终止符，不需特殊处理字符串结尾
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) <= '9' && str.charAt(i) >= '0'){
                tmp += str.charAt(i);
            }else{
                if(!tmp.isEmpty()){
                    res = Math.max(res, Integer.parseInt(tmp));
                }
                if(!tmp0.isEmpty()){
                    String temp1 = tmp0 + '.' + tmp;
                    res = Math.max(res, Double.parseDouble(temp1));
                }
                if(str.charAt(i) == '.'){
                    tmp0 = tmp;
                    tmp = "";
                }else{//是字符的话
                    tmp0 = "";
                    tmp = "";
                }
            }
        }
        System.out.println(res);
    }
}
//大概是这么个思路，写了个伪代码，看起来可能更清晰
//        s+="#" //设置终止符，不需特殊处理字符串结尾
//        string tmp0="", tmp="";
//        foreach ch in s{
//        if ch is num
//        tmp+=ch;
//        else //ch is not num
//        if tmp0 is not empty
//        ans =  max(ans, tmp0.tmp);
//        tmp0 = "";
//        if ch is '.'
//        tmp0=tmp; tmp="";
//        else //ch is not '.'
//        ans = max(ans, tmp);
//        tmp="";
//        }
//