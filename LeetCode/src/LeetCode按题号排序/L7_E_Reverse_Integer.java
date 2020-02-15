package LeetCode按题号排序;


/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * @author tank
 * @create 2020/02/15 09:44
 */
public class L7_E_Reverse_Integer {
    public static void main(String[] args) {
        L7_E_Reverse_Integer l7 = new L7_E_Reverse_Integer();
        int reverse = l7.reverse(
                -2147483648);
        System.out.println(reverse);
    }
    public int reverse(int x) {
        boolean positive = true;
        if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
            return 0;
        }
        if (x < 0) {
            positive = false;
            x = -x;
        }
        StringBuilder sb = new StringBuilder("" + x);
        String str = sb.reverse().toString();
        Long aLong = new Long(str);
        if (aLong > Integer.MAX_VALUE) {
            return 0;
        }else{
            return positive ? aLong.intValue() : -aLong.intValue();
        }
    }
}
