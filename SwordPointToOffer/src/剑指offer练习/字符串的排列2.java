package 剑指offer练习;

import java.util.ArrayList;

/**
 * @author tankInternshipInterview
 * @create 2019/08/14 07:47
 */
public class 字符串的排列2 {
    ArrayList<String> res= new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chars = str.toCharArray();
        backTracking(chars, new boolean[chars.length], new StringBuilder());
        return res;
    }
    private void backTracking(char[] chars, boolean[] hasUsed, StringBuilder sb)
    {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) {
                continue;
            }
            hasUsed[i] = true;
            sb.append(chars[i]);
            backTracking(chars,hasUsed,sb);
            sb.deleteCharAt(sb.length() - 1);
            hasUsed[i] = false;
        }
    }
}
