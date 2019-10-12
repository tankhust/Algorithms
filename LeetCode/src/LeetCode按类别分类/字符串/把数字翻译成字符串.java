package LeetCode按类别分类.字符串;

/**
 * @author tankInternshipInterview
 * @create 2019/08/14 08:11
 */
public class 把数字翻译成字符串 {
    public static void main(String[] args) {
        System.out.println(new 把数字翻译成字符串().numDecodings("12258"));
    }
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int temp = Integer.valueOf(s.substring(i - 1, i));
            if (temp != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int temp2 = Integer.valueOf(s.substring(i - 2, i));
            if (temp2 <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
