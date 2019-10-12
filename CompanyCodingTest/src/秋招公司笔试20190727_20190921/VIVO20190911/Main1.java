package 秋招公司笔试20190727_20190921.VIVO20190911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author tankInternshipInterview
 * @create 2019/09/11 16:52
 */
public class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr);
        System.out.println(output);
    }

    private static int solution(String str) {

        // TODO Write your code here
        Stack<Character> stack = new Stack<>();
        int res = 0;
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (str.charAt(i) == '0') {
                    res = stack.size();
                    break;
                } else if (str.charAt(i) == ')') {
                    stack.pop();
                }
            }
            i++;
        }
        return res;
    }
}
