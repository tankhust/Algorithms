package 春招公司笔试20190310_20190515.basicClass;

import java.util.Arrays;
import java.util.Comparator;

public class Code_30_LowestLexicography {//最小字典序

    public static class lowestStringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return ((o1 + o2).compareTo(o2 + o1));
        }
    }

    public static String lowestString(String[] str) {
        if (str == null || str.length == 0) {
            return null;
        }
        Arrays.sort(str, new lowestStringComparator());
        String res = "";
        for (int i = 0; i <str.length ; i++) {
            res += str[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"b", "a", "d", "c"};
        String result = lowestString(str);
        System.out.println(result);

        System.out.println("==========================");

        String[] str2 = {"bb", "ba", "bad", "caa"};
        result = lowestString(str2);
        System.out.println(result);
    }
}
