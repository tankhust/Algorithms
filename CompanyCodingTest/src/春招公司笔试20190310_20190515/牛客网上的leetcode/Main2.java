package 春招公司笔试20190310_20190515.牛客网上的leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author tankInternshipInterview
 * @create 2019/05/26 11:42
 */

public class Main2 {
    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        if(tokens.length < 3)
            return 0;
        Stack<String> stack = new Stack<>();
        List<String> list = Arrays.asList("+", "-", "*", "/");
        int result = 0;
        int i = 0;
        while(i < tokens.length){
            if(!list.contains(tokens[i])){
                stack.push(tokens[i]);
            }else{
                String temp1 = stack.pop();
                String temp2 = stack.pop();
                int val1 = Integer.parseInt(temp1);
                int val2 = Integer.parseInt(temp2);
                if(tokens[i].equals("+")){
                    result = val2 + val1;
                }else if(tokens[i].equals("-")){
                    result = val2 - val1;
                }else if(tokens[i].equals("*")){
                    result = val2 * val1;
                }else{
                    result = val2 / val1;
                }
                stack.push(String.valueOf(result));
            }
            i++;
        }
        return result;
    }
}