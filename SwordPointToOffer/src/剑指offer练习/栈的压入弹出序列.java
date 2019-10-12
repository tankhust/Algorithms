package 剑指offer练习;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该
 * 压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个
 * 序列的长度是相等的）
 *
 * @author tankInternshipInterview
 * @create 2019/07/12 08:37
 */
public class 栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
//        int[] popA = {4,5,3,2,1};
        int[] popA = {4,3,5,1,2};
        System.out.println(new 栈的压入弹出序列().isPopOrder(pushA, popA));
    }
    // 用一个栈模拟压入，弹出序列
    private boolean isPopOrder(int[] pushA, int[] popA){
        int m = pushA.length, n = popA.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0, j = 0; i < m; i++){
            stack.push(pushA[i]);
            while(j < n && popA[j] == stack.peek()){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
