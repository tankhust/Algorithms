package LeetCode按题号排序;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 * @author tank
 * @create 2020/02/19 11:12
 */
public class L10_H_Regular_Expression_Matching {
    public static void main(String[] args) {
        L10_H_Regular_Expression_Matching l10 = new L10_H_Regular_Expression_Matching();
        String s = "aa", p = "a";
        System.out.println(l10.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        return false;
    }
}
