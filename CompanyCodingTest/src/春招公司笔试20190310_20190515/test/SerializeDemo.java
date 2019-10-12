/*
package tankInternshipInterview.practice.test;

*/
/**
 * @author tankInternshipInterview
 * @create 2018/12/08 11:46
 *//*

*/
/**
 * 序列化
 *//*


import java.io.*;

public class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "huzhu";
        e.address = "HUST";
        e.number = 100;
        e.SSN = 1001;
        try {
            FileOutputStream fileOut = new FileOutputStream("..\\test3.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}*/
