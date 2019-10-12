package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2019/04/13 13:26
 */
public class test5 {
    private static int x = 10;

    private static Integer y = 10;



    public static void updateX(int value) {

        value = 3 * value;

    }



    public static void updateY(Integer value) {

        value = 3 * value;

    }



    public static void main(String[] args) {

        updateX(x);
        System.out.println(x);
        updateY(y);
        System.out.println(y);

    }

}
