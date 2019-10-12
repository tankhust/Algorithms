package 剑指offer练习;

/**
 * @author tankInternshipInterview
 * @create 2019/07/10 23:46
 */
public class 二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(new 二进制中1的个数().Soulution(4));
    }

    public int Soulution(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }
}
