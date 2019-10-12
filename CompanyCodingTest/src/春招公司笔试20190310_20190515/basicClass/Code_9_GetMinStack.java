package 春招公司笔试20190310_20190515.basicClass;

import java.util.Stack;

public class Code_9_GetMinStack {//能获取最小值的栈
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public Code_9_GetMinStack() {
        dataStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (minStack.isEmpty()) {
            minStack.push(newNum);
        }else if(minStack.peek()>newNum){
            minStack.push(newNum);
        }else{
            minStack.push(minStack.peek());
        }
        dataStack.push(newNum);
    }

    public int pop() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("the stack is empty");
        }
        dataStack.pop();
        return minStack.pop();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("the stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        Code_9_GetMinStack stack=new Code_9_GetMinStack();
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}
