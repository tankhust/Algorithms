package 剑指offer练习;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @author tankInternshipInterview
 * @create 2019/07/14 15:09
 */
public class 字符串的排列 {
    public static void main(String[] args) {
        System.out.println(new 字符串的排列().Permutation("abc"));
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null) {
            return res;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backTracing(chars, new boolean[chars.length], res, new StringBuilder());
        return res;
    }

    private void backTracing(char[] chars, boolean[] isVisited, ArrayList<String> res, StringBuilder sb) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }
        for(int i = 0; i < chars.length; i++){
            if(isVisited[i])
                continue;
            if(i != 0 && chars[i] == chars[i - 1] && !isVisited[i - 1])
                continue;
            isVisited[i] = true;
            sb.append(chars[i]);
            backTracing(chars, isVisited, res, sb);
            sb.deleteCharAt(sb.length() - 1);
            isVisited[i] = false;
        }
    }
}
