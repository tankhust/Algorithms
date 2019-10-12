package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2019/02/20 19:52
 */
public class nowcoder_test1 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,100,10};
        int x = arr[0];
        int f = arr[1];
        int d = arr[2];
        int p = arr[3];
        int res = 0;
        if(d <= f * x){//在已有水果吃光前就没钱了
            res = d / x;
        }else{//在已有水果吃光后还有钱
            res = (d - f * x) / (p + x) + f;
        }
        System.out.println(res);
    }
}
