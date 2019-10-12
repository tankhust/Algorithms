package 剑指offer练习;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author tankInternshipInterview
 * @create 2019/07/10 23:34
 */
public class 矩阵覆盖 {
    public static void main(String[] args) {
        System.out.println(new 矩阵覆盖().RectCover(4));
    }
    public int RectCover(int target) {
        if(target < 1)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
