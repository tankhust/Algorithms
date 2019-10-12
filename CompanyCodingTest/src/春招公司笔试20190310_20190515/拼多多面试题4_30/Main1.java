package 春招公司笔试20190310_20190515.拼多多面试题4_30;

import java.util.Scanner;

/**
 * 自己面试的时候写的，挂了，复杂度高了
 * @author tankInternshipInterview
 * @create 2019/04/30 14:13
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }
    public void solve(String str){
        String[] strr = str.split(".");
        int max = Integer.MIN_VALUE;
        int index = 0;
        boolean hasNext = false;//判断最后结果是否有小数点
        //找到最大的合法数字（不含小数点的）
        for(int i = 0; i < strr.length; i++){
            for(int j = 0; j < strr[i].length(); j++){
                for(int k = j; k < strr[i].length(); k++){
                    String sub = strr[i].substring(j, k);
                    if(isValid(sub)){
                        max = Math.max(max, Integer.parseInt(sub));
                        index = i;
                        if(index == strr[i].length() - 1){
                            hasNext = true;
                        }
                    }
                }
            }
        }
        String sub2 = "";
        if(hasNext){
            for(int i = 0; i < strr[index + 1].length(); i++){
                char c = strr[index + 1].charAt(i);
                if(c <= '9' && c >= '0'){
                    sub2 +=c;
                }else{
                    break;
                }
            }
        }
        //结果分有小数点和无小数点
        String res = String.valueOf(max);
        res = hasNext ? String.valueOf(max) + "." + sub2 : String.valueOf(max);
        System.out.println(res);//结果

    }
    public static boolean isValid(String str){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) > '9' || str.charAt(i) < '0'){
                return false;
            }
        }
        return true;
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

