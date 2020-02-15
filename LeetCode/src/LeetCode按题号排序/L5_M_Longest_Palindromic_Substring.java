package LeetCode按题号排序;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author tank
 * @create 2020/02/15 08:54
 */
public class L5_M_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        L5_M_Longest_Palindromic_Substring l5 = new L5_M_Longest_Palindromic_Substring();
        String s = "babad";
        String result = l5.longestPalindrome(s);
        System.out.println(result);
    }
    private int left = 0;
    private int length = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            getPalindromeLength(s, i, i);
            getPalindromeLength(s, i, i + 1);
        }
        return s.substring(left, left + length);
    }

    public void getPalindromeLength(String s, int l, int r) {
        if (l < 0 || r > s.length() - 1 || s.charAt(l) != s.charAt(r)) {
            return;
        }
        while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (length < r - l - 1) {
            left = l + 1;
            length = r - l - 1;
        }
    }
}
