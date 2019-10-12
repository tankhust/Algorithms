package 春招公司笔试20190310_20190515.test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author tankInternshipInterview
 * @create 2019/02/27 16:22
 */
public class ProducerConsumer {

    public static class Producer implements Runnable {
        private BlockingQueue<Integer> blockingQueue;
        private Random random = new Random();

        public Producer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    Integer i = random.nextInt(10);
                    blockingQueue.put(i);
                    System.out.println(Thread.currentThread().getName() + "生产了" + i + "此时队列大小为" + blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Consumer implements Runnable {
        private BlockingQueue<Integer> blockingQueue;

        public Consumer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    Integer i = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + "消费了" + i + ",此时队列大小为" + blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
        ExecutorService exec = Executors.newCachedThreadPool();
        int producerNum = 3;
        int consumerNum = 5;
        for (int i = 0; i < producerNum; i++) {
            exec.submit(new Producer(blockingQueue));
        }
        for (int i = 0; i < consumerNum; i++) {
            exec.submit(new Consumer(blockingQueue));
        }
    }
}
