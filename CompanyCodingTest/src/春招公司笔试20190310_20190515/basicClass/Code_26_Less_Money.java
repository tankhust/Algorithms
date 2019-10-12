package 春招公司笔试20190310_20190515.basicClass;

import java.util.PriorityQueue;

public class Code_26_Less_Money {//分金条问题

    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; ++i) {
            priorityQueue.offer(arr[i]);
        }
        int sum=0;//代价
        int cur=0;//当前花费
        while (priorityQueue.size() > 1) {
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            priorityQueue.offer(cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 9};
        System.out.println(lessMoney(arr));

    }
}
