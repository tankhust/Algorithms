package 春招公司笔试20190310_20190515.华为笔试4_10;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author tankInternshipInterview
 * @create 2019/04/10 19:59
 */
public class Main2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(checkLen(s,0));
    }
    private static int checkLen(String s, int index){
        Stack<Character> stack = new Stack<>();
        int len = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(index);
            if (c == '(' || c == '{' || c == '['){
                len += 1;
                stack.push(c);
                continue;
            }else if(c <= '9' && c >= '0'){
                len += 1;
                continue;
            }else if(c >= 'a' && c <= 'z'){
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
