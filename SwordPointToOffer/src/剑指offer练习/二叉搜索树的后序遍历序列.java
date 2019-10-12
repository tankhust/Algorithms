package 剑指offer练习;

/**
 * @author tankInternshipInterview
 * @create 2019/07/14 09:55
 */
public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        /**
         *      true
         *        5
         *      3   7
         *    1  4 6  9
         *    后序遍历结果：
         *     true           false
         *    1436975        1436957
         */
        int[] sequence1 = {1,4,3,6,9,7,5};
        int[] sequence2 = {1,4,3,6,9,5,7};
        System.out.println(new 二叉搜索树的后序遍历序列().VerifySquenceOfBST(sequence1));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {
        if(start + 1>= end){
            return true;
        }
        int rootValue = sequence[end];
        int index = start;
        while (index < end && sequence[index] <= rootValue) {
            index++;
        }
        for (int i = index; i < end; i++) {
            if(sequence[i] <rootValue){
                return false;
            }
        }
        return verify(sequence, start, index - 1) && verify(sequence, index, end - 1);
    }
}
