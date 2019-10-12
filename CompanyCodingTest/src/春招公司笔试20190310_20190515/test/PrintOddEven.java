package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2019/02/27 15:52
 */
public class PrintOddEven {
    private static final Object lock = new Object();
    private static int count = 1;

    static class PrintOdd implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    try {
                        while ((count & 1) != 1) {
                            lock.wait();
                        }
                        System.out.println(Thread.currentThread().getName()+" "+count);
                        count++;
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class PrintEven implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    try {
                        while ((count & 1) != 0) {
                            lock.wait();//lock在wait时会释放锁
                        }
                        System.out.println(Thread.currentThread().getName()+" "+count);
                        count++;
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintEven());
        Thread t2 = new Thread(new PrintOdd());
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
