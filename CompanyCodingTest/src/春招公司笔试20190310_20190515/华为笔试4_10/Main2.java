package 春招公司笔试20190310_20190515.华为笔试4_10;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author tankInternshipInterview
 * @create 2019/04/10 19:24
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String res = checkStr1(s,0, s.length() - 1);
        System.out.println(res);
//        System.out.println(new StringBuilder(res).reverse());
    }
    private static String checkStr1(String s, int start, int end) {
        String res = "";
        int i = start;
        while(i <= end){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int count = s.charAt(i) - '0';
                int curLen = checkLen(s, i);//当前位置的对应括号字符串的长度,例如3(a)的长度为4
                String temp = checkStr1(s, i + 2, i + curLen - 2);//避开括号
                while(count-- > 0){
                    res += temp;
                }
                i += curLen;
            }else{
                res += String.valueOf(s.charAt(i));
                i++;
            }
        }
        return res;
    }
    private static int checkLen(String s, int index){
        Stack<Character> stack = new Stack<>();
        int len = 0;
        for(int i = index; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                len += 1;
                stack.push(c);
                continue;
            }else if(c <= '9' && c >= '0'){
                len += 1;
                continue;
            }else if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
                len +=1;
                continue;
            }else{
                if(c == ')' || c == '}' || c == ']'){
                    stack.pop();
                    len += 1;
                    if(stack.isEmpty()){
                        break;
                    }
                }
            }
        }
        return len;
    }
}
