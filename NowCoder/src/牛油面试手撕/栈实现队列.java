package 牛油面试手撕;

import java.util.Stack;

/**
 * @author tankInternshipInterview
 * @create 2019/07/27 12:06
 */
public class 栈实现队列 {
    public static void main(String[] args) {
        栈实现队列 solution = new 栈实现队列();
        solution.push(1);
        System.out.println(solution.pop());
        solution.push(2);
        solution.push(3);
        System.out.println(solution.pop());
        System.out.println(solution.pop());

    }

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    private void push(int val) {
        s1.push(val);
    }

    private int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
