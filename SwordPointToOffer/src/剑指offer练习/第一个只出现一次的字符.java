package 剑指offer练习;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * @author tankInternshipInterview
 * @create 2019/07/14 17:01
 */
public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        System.out.println(new 第一个只出现一次的字符().FirstNotRepeatingChar("11223344566757"));
    }
    public int FirstNotRepeatingChar(String str) {
        int[] cnt = new int[256];
        for(int i = 0; i < str.length(); i++){
            cnt[str.charAt(i)]++;
        }
        for(int i = 0; i < str.length(); i++){
            if(cnt[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
}
