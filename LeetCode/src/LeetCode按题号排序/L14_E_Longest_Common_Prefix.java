package LeetCode按题号排序;

/**
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * @author tank
 * @create 2020/03/04 21:18
 */
public class L14_E_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String firstStr = strs[0];
        String result = "";
        String prefixTemp = "";

        for (int i = 0; i < firstStr.length(); i++) {
            prefixTemp = prefixTemp + firstStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(!strs[j].startsWith(prefixTemp)){
                    prefixTemp = "";
                    break;
                }
            }
            if (prefixTemp.isEmpty()) {
                break;
            }
            result = prefixTemp;
        }
        return result;
    }

    /**
     * 大神解答
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while(!strs[i].startsWith(pre))
                pre = pre.substring(0, pre.length() - 1);
        }
        return pre;
    }

        public static void main(String[] args) {
        L14_E_Longest_Common_Prefix l14 = new L14_E_Longest_Common_Prefix();
        String[] strs = {"flower","flow","flight"};
//        String[] strs = {""};
        String s = l14.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
