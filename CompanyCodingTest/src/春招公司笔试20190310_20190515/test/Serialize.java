package 春招公司笔试20190310_20190515.test;

import java.io.File;

/**
 * @author tankInternshipInterview
 * @create 2018/12/08 11:41
 */
public class Serialize {
    public static void main(String[] args) {
        File file = null;
        try {
            file = new File("src\\com\\tankInternshipInterview\\practice\\test\\test3.txt");
            file.createNewFile();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
