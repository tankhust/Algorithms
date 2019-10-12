package 春招公司笔试20190310_20190515.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author tankInternshipInterview
 * @create 2019/03/03 17:10
 */
public class CyclicBarrier_test {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(4);
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }
    }

    static class Writer extends Thread {
        private CyclicBarrier barrier;

        public Writer(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(500); //以睡眠来模拟线程需要预定写入数据操作
                System.out.println("线程 "+Thread.currentThread().getName()+"写入数据完 毕，等待其他线程写入完毕");
                barrier.await();
                System.out.println("所有线程写入完毕，继续处理其他任务，比如数据操作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
