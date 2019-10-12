package 剑指offer练习;

import java.util.Stack;

/**
 * @author tankInternshipInterview
 * @create 2019/08/14 07:03
 */
public class 栈的压入弹出序列2 {
    public boolean isPopSequence(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            stack.push(pushSequence[i]);
            while (!stack.isEmpty() && index < n && stack.peek() == popSequence[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
