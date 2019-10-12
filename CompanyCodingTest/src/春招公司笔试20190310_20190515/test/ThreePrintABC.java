package 春招公司笔试20190310_20190515.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tankInternshipInterview
 * @create 2019/02/27 16:00
 */
public class ThreePrintABC {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition wait = lock.newCondition();
    private static int count = 0;

    static class ThreadA implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while((count % 3) != 0){
                        wait.await();
                    }
                    System.out.println(Thread.currentThread().getName()+" "+"A");
                    count++;
                    wait.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    static class ThreadB implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while((count % 3) != 1){
                        wait.await();
                    }
                    System.out.println(Thread.currentThread().getName()+" "+"B");
                    count++;
                    wait.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    static class ThreadC implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while((count % 3) != 2){
                        wait.await();
                    }
                    System.out.println(Thread.currentThread().getName()+" "+"C");
                    count++;
                    wait.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadA());
        Thread t2 = new Thread(new ThreadB());
        Thread t3 = new Thread(new ThreadC());
        t1.start();
        t2.start();
        t3.start();
    }
}
