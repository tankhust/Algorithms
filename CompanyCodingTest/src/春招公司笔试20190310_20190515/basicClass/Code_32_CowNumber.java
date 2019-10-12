package 春招公司笔试20190310_20190515.basicClass;

public class Code_32_CowNumber {//奶牛数量问题，像这种递推式的复杂度为O(N)的都可以转换为O(lgN)的
    public static int cowNumber1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        return cowNumber1(n - 1) + cowNumber1(n - 3);
    }

    public static void main(String[] args) {
        int n=20;
        System.out.println(cowNumber1(20));
    }
}
