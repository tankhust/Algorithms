package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2019/03/09 16:14
 */
public class test2 {
    public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}
class Person {
    String name = "No name";

}
class Employee extends Person {
    String empID = "0000";
    int num = 0;
    public Employee(String id) {
        empID = id;
    }
}