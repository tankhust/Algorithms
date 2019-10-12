package 剑指offer练习;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * @author tankInternshipInterview
 * @create 2019/07/18 23:08
 */
public class 和为S的连续正数序列 {
    public static void main(String[] args) {
        int sum = 5;
        System.out.println(new 和为S的连续正数序列().findContinuousSequence(sum));
    }

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {

            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                res.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }else if(curSum < sum){
                end++;
                curSum += end;
            }else{
                curSum -= start;
                start++;
            }
        }
        return res;
    }
}
