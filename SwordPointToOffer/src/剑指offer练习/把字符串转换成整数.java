package 剑指offer练习;

/**
 *
 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * @author tankInternshipInterview
 * @create 2019/07/20 00:05
 */
public class 把字符串转换成整数 {
    public static void main(String[] args) {
        String str = "-+234324";
        System.out.println(new 把字符串转换成整数().StrToInt(str));
    }
    public int StrToInt(String str) {
        if(str == null || str.length() == 0)
            return 0;
        boolean isNegative = false;
        if(str.charAt(0) == '-'){
            isNegative = true;
        }
        char[] chars = str.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && (chars[i] == '-' || chars[i] == '+')) {
                continue;
            }
            if(chars[i] < '0' || chars[i] > '9'){
                return 0;
            }
            res = res * 10 + chars[i] - '0';
        }
        return isNegative ? -res : res;
    }
}
