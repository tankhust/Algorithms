package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2018/12/13 11:20
 */
import java.util.Date;
public class SuperTest extends Date{
    private static final long serialVersionUID = 1L;
    private void test(){
        System.out.println(super.getClass().getSuperclass().getName());
    }

    public static void main(String[]args){
        new SuperTest().test();
    }
}
