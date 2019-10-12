package 春招公司笔试20190310_20190515.test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author tankInternshipInterview
 * @create 2019/03/02 15:42
 */
public class Solution {

    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (num-- >= 0) {
            String str = sc.nextLine();
            if (str.startsWith("push")) {
                String[] s = str.split(" ");
                push(s[1]);
            }
            if (str.startsWith("delete")) {
                String[] s = str.split(" ");
                delete(s[1]);
            }
            if (str.equals("query")) {
                query();
            }
            if (str.equals("pop")) {
                pop();
            }
        }
    }

    public static void push(String s) {
        stack.push(Integer.valueOf(s));
    }

    public static void delete(String s) {
        if (!stack.isEmpty()) {
            Stack<Integer> stack2 = new Stack<>();
            while(!stack.isEmpty()){
                if(stack.peek() == Integer.valueOf(s)){
                    stack.pop();
                    break;
                }
                stack2.push(stack.pop());
            }
            while(!stack2.isEmpty()){
                stack.push(stack2.pop());
            }

        }
    }

    public static void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public static void query() {
        System.out.println(stack.peek());
    }


}
