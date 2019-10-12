package 春招公司笔试20190310_20190515.basicClass;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_10_StackAndQueueConvert {//栈和队列的转换
    public static class TwoStacksQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public TwoStacksQueue() {
            pushStack = new Stack<Integer>();
            popStack = new Stack<Integer>();
        }

        public void offer(int newNum) {
            pushStack.push(newNum);
        }

        public int poll() {
            if (pushStack.isEmpty() && popStack.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }else if(popStack.isEmpty()){
                while(!pushStack.isEmpty()){popStack.push(pushStack.pop());}
            }
            return popStack.pop();
        }

        public int peek() {
            if (pushStack.isEmpty() && popStack.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }else if(popStack.isEmpty()){
                while(!pushStack.isEmpty()){popStack.push(pushStack.pop());}
            }
            return popStack.peek();
        }
    }

    public static class TwoQueuesStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int newNum) {
            queue.add(newNum);
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("the Stack is empty");
            }
            while (queue.size() != 1) {
                help.add(queue.poll());
            }
            int tmp =queue.poll();
            while(!help.isEmpty()){
                queue.add(help.poll());
            }
            return tmp;
        }

        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("the Stack is empty");
            }
            while (queue.size() != 1) {
                help.add(queue.poll());
            }
            int tmp=queue.peek();
            help.add(tmp);
            while(!help.isEmpty()){
                queue.add(help.poll());
            }
            return tmp;
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue queue =new TwoStacksQueue();
        queue.offer(1);
        queue.offer(5);
        queue.offer(3);
        queue.offer(4);
        for (int i = 0; i < 4; i++) {
            System.out.println(queue.poll());
//            System.out.println(queue.peek());
        }

        System.out.println("====================================");

        TwoQueuesStack stack=new TwoQueuesStack();
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        for (int i = 0; i < 4; i++) {
            System.out.println(stack.pop());
        }




    }
}
