package 春招公司笔试20190310_20190515.剑指offer;

import java.util.PriorityQueue;

/**
 * @author tankInternshipInterview
 * @create 2019/03/30 14:58
 */
public class 数据流的中位数 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.Insert(1);
        System.out.println(s.GetMedian());

        s.Insert(2);
        System.out.println(s.GetMedian());

        s.Insert(3);
        System.out.println(s.GetMedian());

    }
     static class Solution {
        PriorityQueue<Integer> maxStack = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minStack = new PriorityQueue<>();
        int n = 0;
        public void Insert(Integer num) {
            if(n%2 == 0){
                maxStack.add(num);
                minStack.add(maxStack.poll());
            }else{
                minStack.add(num);
                maxStack.add(minStack.poll());
            }
            n++;
        }

        public Double GetMedian() {
            if(n%2 == 1){
                return (double)minStack.peek();
            }else{
                return (minStack.peek()+maxStack.peek())/2.0;
            }
        }
    }
}
