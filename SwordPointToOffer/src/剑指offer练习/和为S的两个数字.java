package 剑指offer练习;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @author tankInternshipInterview
 * @create 2019/07/18 23:21
 */
public class 和为S的两个数字 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(new 和为S的两个数字().findNumbersWithNum(array, 5));
    }
    public ArrayList<Integer> findNumbersWithNum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int l = 0, h = array.length - 1;
        while(l < h){
            if (array[l] + array[h] == sum) {
                res.add(array[l]);
                res.add(array[h]);
                return res;
            } else if (array[l] + array[h] < sum) {
                l++;
            }else{
                h--;
            }
        }
        return res;
    }
}
