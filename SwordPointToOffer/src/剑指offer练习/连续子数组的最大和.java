package 剑指offer练习;

import java.util.Arrays;
import java.util.List;

/**
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * @author tankInternshipInterview
 * @create 2019/07/14 16:20
 */
public class 连续子数组的最大和 {
    public static void main(String[] args) {
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(new 连续子数组的最大和().findGreatestSumOfSubArray(array));
    }
    public List<Integer> findGreatestSumOfSubArray(int[] array){
        int curSum = 0, res = 0;
        int start = 0, end = 0;
        for(int i = 0; i < array.length; i++){
            if(curSum > 0){
                curSum = curSum + array[i];
                if(res < curSum){
                    res = curSum;
                    end = i;
                }
            }else{
                curSum = array[i];
                if(res < curSum){
                    res = curSum;
                    start = i;
                    end = i;
                }
            }
        }
        return Arrays.asList(res, start, end);
    }
}
