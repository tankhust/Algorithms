package 剑指offer练习;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author tankInternshipInterview
 * @create 2019/07/14 15:32
 */
public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(new 数组中出现次数超过一半的数字().MoreThanHalfNum_Solution(array));
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        int majority = array[0];
        for(int i = 1, cnt = 1; i < array.length; i++){
            cnt = array[i] == majority ? cnt + 1 : cnt - 1;
            if(cnt == 0){
                majority = array[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for(int temp : array){
            if(temp == majority)
                cnt++;
        }
        return cnt > array.length / 2 ? majority : 0;
    }
}
