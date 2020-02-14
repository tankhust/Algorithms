package LeetCode按题号排序;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @author tank
 * @create 2020/02/13 21:11
 */
public class L3_M_Length_Of_Longest_Substring {
    public static void main(String[] args) {
        L3_M_Length_Of_Longest_Substring l3 = new L3_M_Length_Of_Longest_Substring();
        String str = "pwwkew";
        int n = l3.lengthOfLongestSubstring(str);
        System.out.println(n);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] map = new int[256];
        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()) {
            if(l < s.length() && map[s.charAt(r)] == 0) {
                res = Math.max(res, r - l + 1);
                map[s.charAt(r)]++;
                r++;
            }else{
                map[s.charAt(l++)]--;
            }
        }
        return res;
    }
}
