package 春招公司笔试20190310_20190515.携程4_8;

/**
 * @author tankInternshipInterview
 * @create 2019/04/08 21:03
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println("a" + "b" == "ab");
        System.out.println("ab" == new String("ab"));
        System.out.println(("a"+ "b").intern() == "ab".intern());
        System.out.println("ab" == new String("ab").intern());

        System.out.println(Integer.MAX_VALUE - Integer.MIN_VALUE);
    }
}
