package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2019/04/08 18:57
 */
public class test666 {
    public static void main(String[] args) {
        A a = new B();
        a.printMessage();
    }
}
class A{
    int x = 1;

    public A() {
        this.printMessage();
        x = 2;
        System.out.println(x);
    }

    public void printMessage() {
        System.out.println(x);
    }
}
class B extends A{
    int x = 3;

    public B() {
        this.printMessage();
        x = 4;
        System.out.println(x);
    }

    public void printMessage() {
        System.out.println(x);
    }
}
