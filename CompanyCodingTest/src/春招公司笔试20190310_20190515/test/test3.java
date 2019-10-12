package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2019/04/13 13:20
 */
public class test3 {
    public static void main(String[] args) {

        System.out.print(B1.c1);

    }
}
class A1 {


    static {

        System.out.print("A1");

    }

}



class B1 extends A1{

    static {

        System.out.print("B1");

    }
    public final static String c1 = "C1";


}