package 秋招公司笔试20190727_20190921.Shopee笔试题20190727_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 * 示例1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * 提示：
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 * @author tankInternshipInterview
 * @create 2019/07/27 19:28
 */
public class 除尽字符串 {
    public static void main(String[] args) {
        System.out.println(new 除尽字符串().gcdOfStrings("ABCABC", "ABC"));
        System.out.println(new 除尽字符串().gcdOfStrings("ABABAB", "AB"));
        System.out.println(new 除尽字符串().gcdOfStrings("LEFT", "CODE"));
    }
    /**
     * 5076. 字符串的最大公因子
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        List<String> loopStr1=findLoopStrings(str1);
        List<String> loopStr2=findLoopStrings(str2);
        List<String> union=new ArrayList<>();
        if(!loopStr1.isEmpty() && !loopStr2.isEmpty()){// 不存在循环因子
            for(String l1:loopStr1){// 进行并集运算，提取公因子
                for (String l2: loopStr2) {
                    if(l1.equals(l2)){
                        union.add(l1);
                    }
                }
            }
            if(union.isEmpty()){// 无公因子，直接返回空字符
                return "";
            }
            // 找出长度最大的字符串
            return union.stream().collect(Collectors.maxBy(Comparator.comparing(String::length))).get();
        }
        return "";
    }

    /**
     * 获取组成循环字符串的子串
     * @param str
     * @return
     */
    private List<String> findLoopStrings(String str){
        List<String> result=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            // 循环子串
            String subStr=str.substring(0,i+1);
            if(str.length()%subStr.length()==0){// 子串长度可以被原字符串长度整除
                // 比较次数
                int times= str.length()/subStr.length();
                // 是否匹配
                boolean match=true;
                for(int j=0;j<times;j++){
                    if(!str.substring(j*subStr.length(),(j+1)*subStr.length()).equals(subStr)){
                        match=false;
                        break;
                    }
                }
                if(match){
                    result.add(subStr);
                }
            }
        }
        return result;
    }

}
