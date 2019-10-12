package 剑指offer练习;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * @author tankInternshipInterview
 * @create 2019/07/18 23:52
 */
public class 翻转单词序列 {
    public static void main(String[] args) {
        String str = "I am a student.";
        System.out.println(new 翻转单词序列().ReverseSentence(str));
    }

    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        int n = str.length();
        while (j <= n) {
            if(j == n || str.charAt(j) == ' '){
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars,0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
