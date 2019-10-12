package 剑指offer练习;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author tankInternshipInterview
 * @create 2019/07/18 22:39
 */
public class 数组中只出现一次的数字 {
    public static void main(String[] args) {
        int[] array = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new 数组中只出现一次的数字().FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int diff = 0;
        for (int num : array) {
            diff ^= num;
        }
        System.out.println("diff:" + diff);
        diff &= -diff;// 得出diff最右侧不同的哪一位
        System.out.println(diff &= -diff);
        for (int num : array) {
            if((num & diff) == 0){
                num1[0] ^= num;
            }else{
                num2[0] ^= num;
            }
        }
    }
}
