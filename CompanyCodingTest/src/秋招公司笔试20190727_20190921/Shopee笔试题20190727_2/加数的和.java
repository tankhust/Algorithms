package 秋招公司笔试20190727_20190921.Shopee笔试题20190727_2;

/**
 * 给定一个有n个正整数的数组A和一个整数sum。求选择数组A中部分数字和为sum的方案数。
 * 当两种方案有一个数字的下标不一样，我们就认为是不同的组成方案
 *
 * 输入
 * 5 15
 * 5 5 10 2 3
 *
 * 输出
 * 4
 *
 * @author tankInternshipInterview
 * @create 2019/07/27 19:29
 */
public class 加数的和 {
    public static void main(String[] args) throws Exception
    {
        int[] arr ={5,5,5,2,3};
        System.out.println("方案数:"+getAllSchemeNum(arr,15));
    }

    public static int getAllSchemeNum(int[] arr,int sum)
    {
        int count=0;
        //将选择一个数，两个数...n个数时的方案数相加
        for(int num=1;num<=arr.length;num++)
        {
            //getNumIfChosseM是选择m个数时得到的方案数
            count+=getSchemeNumIfChooseM(arr,num,0,sum);
        }
        return count;
    }

    /**
     *
     * @param arr		数组A
     * @param num		还需要选择的数的个数
     * @param index		可选的范围的左边界
     * @param sum		还需要选择数之和
     * @return
     */
    public static int getSchemeNumIfChooseM(int[] arr, int num,int index,int sum)
    {
        int count=0;

        //如果全部选择完成，则只需判定sum是否为零，如果为零，符合条件，返回1，否则返回0
        if(num==0)
        {
            return sum==0?1:0;
        }
        //剩余要选的数里，第一个数可选的范围为[index,arr.length-num]
        for(int i=index;i<=arr.length-num;i++)
        {
            if(arr[i]<=sum)
                //可选的个数减一，可选的左边界等于当前确定数的小标加1,
                count+=getSchemeNumIfChooseM(arr,num-1,i+1,sum-arr[i]);
        }

        return count;
    }

}
