package LeetCode按类别分类.字符串;

/**
 * @author tankInternshipInterview
 * @create 2019/08/20 16:15
 */
public class 回文子字符串的个数 {
    private int count = 0;
    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(new 回文子字符串的个数().countSubstrings(str));
    }

    private int countSubstrings(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            extendStrings(str, i, i);
            extendStrings(str, i, i + 1);
        }
        return count;
    }

    private void extendStrings(String str, int l, int r) {
        while (l >= 0 && r <= str.length() - 1 && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
            count++;
        }
    }
}
