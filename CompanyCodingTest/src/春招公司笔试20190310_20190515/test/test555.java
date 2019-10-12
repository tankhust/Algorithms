package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2019/04/08 17:06
 */
public class test555 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Hello,World!");
        });
        thread.start();
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();
    }
}

