package 春招公司笔试20190310_20190515.test;

import java.util.concurrent.CountDownLatch;

/**
 * @author tankInternshipInterview
 * @create 2019/03/03 16:57
 */
public class CountDownLatch_test {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("任务1开始执行。。。。");
                    Thread.sleep(3000);
                    System.out.println("任务1执行结束。。。。");
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("任务2开始执行。。。。");
                    Thread.sleep(3000);
                    System.out.println("任务2执行结束。。。。");
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("等待2个子线程执行结束。。。。。。。。。。。。。");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2个子线程执行结束。。。。。。。。。。。。。。");
        System.out.println("继续执行主线程。。。。。。");
    }
}
