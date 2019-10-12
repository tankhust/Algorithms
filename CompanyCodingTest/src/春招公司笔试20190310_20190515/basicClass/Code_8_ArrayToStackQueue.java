package 春招公司笔试20190310_20190515.basicClass;

public class Code_8_ArrayToStackQueue {//数组实现栈和队列
    public static class ArrayToStack {
        private int[] arr;
        private int size;

        public ArrayToStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("the initial size is less than 0");
            }
            arr = new int[initSize];
            size = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size--];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("the stack is full");
            }
            arr[size++] = obj;
        }

        public int pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("the stack is empty");
            }
            return arr[size--];
        }
    }

    public static class ArrayToQueue {
        private int[] arr;
        private int size;
        private int first;
        private int last;

        public ArrayToQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("the initial size is less than 0");
            }
            arr = new int[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[0];
        }

        public void offer(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("the queue is full");
            }
            size++;
            arr[last] = obj;
            last = last == arr.length - 1 ? 0 : last + 1;
        }

        public int poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            }
            size--;
            int tmp = first;
            first = first == arr.length - 1 ? 0 : first + 1;
            return arr[tmp];
        }



    }
}
