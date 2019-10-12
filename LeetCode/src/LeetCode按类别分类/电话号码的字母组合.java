package LeetCode按类别分类;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tankInternshipInterview
 * @create 2019/08/23 14:28
 */
public class 电话号码的字母组合 {
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> res = new ArrayList<>();

    public List<String> letterCombine(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(digits, 0, "");
        return res;
    }

    private void dfs(String digits, int i, String str) {
//        if(i = digits.length())
    }
}
