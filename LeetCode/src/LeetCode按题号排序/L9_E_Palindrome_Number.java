package LeetCode按题号排序;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Follow up:
 * Coud you solve it without converting the integer to a string?
 *
 *
 * @author tank
 * @create 2020/02/18 22:17
 */
public class L9_E_Palindrome_Number {
    public static void main(String[] args) {
        L9_E_Palindrome_Number l9 = new L9_E_Palindrome_Number();
        System.out.println(l9.isPalindrome(121));
        System.out.println(l9.isPalindrome(-121));
        System.out.println(l9.isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        String str = "" + x;
        StringBuilder sb = new StringBuilder(str);
        StringBuilder temp = new StringBuilder(sb);
        if (sb.reverse().toString().equals(temp.toString())) {
            return true;
        }else{
            return false;
        }
    }
}
