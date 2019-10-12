package 春招公司笔试20190310_20190515.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tankInternshipInterview
 * @create 2019/03/06 9:34
 */
public class PrintOddEven_test {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition wait = lock.newCondition();

    private static int count = 0;

    public static void main(String[] args) {
        new Thread(new printOdd()).start();
        new Thread(new printEven()).start();
    }

    static class printOdd implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while((count % 2) != 1){
                        wait.await();
                    }
                    System.out.println(Thread.currentThread().getName()+"："+ count++);
                    wait.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class printEven implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while((count % 2) != 0){
                        wait.await();
                    }
                    System.out.println(Thread.currentThread().getName()+"："+count++);
                    wait.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

}
