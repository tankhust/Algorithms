package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2019/03/05 15:34
 */
public class DecimalToBinary {
    public static void main(String[] args) {
        int num = 10;
        String str = "";
        while(num > 0){
            str += String.valueOf(num & 1);
            num = num >> 1;
        }
        System.out.println(new StringBuilder(str).reverse());
    }
}
