package LeetCode按类别分类;

/**
 * @author tankInternshipInterview
 * @create 2019/08/21 16:22
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(new 无重复字符的最长子串().lengthOfLongestSubstring("abcabcbb"));
    }

    private int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int[] map = new int[256];
        int l = 0;
        int r = 0;
        int res = 0;
        while (l < str.length()) {
            if (r < str.length() && map[str.charAt(r)] == 0) {
                map[str.charAt(r)]++;
                r++;
                res = Math.max(res, r - l);
            }
            else{
                map[str.charAt(l)]--;
                l++;
            }
        }
        return res;
    }
}
