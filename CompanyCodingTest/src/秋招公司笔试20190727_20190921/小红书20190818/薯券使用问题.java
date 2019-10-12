package 秋招公司笔试20190727_20190921.小红书20190818;

import java.util.Scanner;

/**
 * 薯券使用问题
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 某小红薯在小红书的活动中抽奖中了一定价值的薯券，这些薯券可以用来购买一批商品，求有多少种购买组合。其中一件商品可以买多件。输入 : 薯券金额、商品分别价格输出 : 组合数
 *
 * 输入
 * 输入薯券金额、商品分别价格输出，
 *
 * 例如： 10 [2,3,5]，10 与[2,3,5]中间有空格
 *
 * 输出
 * 输出4，则结果集可以为:2,2,2,2,2；5,5；2,3,5；2,2,3,3共有4种组合
 *
 *
 * 样例输入
 * 10 [2,3,5]
 * 样例输出
 * 4
 * @author tankInternshipInterview
 * @create 2019/08/18 15:17
 */
public class 薯券使用问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] res = new int[target + 1];// 用来保存总共找i块钱，所有可能的解决方案的数目
        res[0] = 1;
        String str = sc.next();
        String[] strs = str.substring(1, str.length() - 1).split(",");
        int[] kinds = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            kinds[i] = Integer.valueOf(strs[i]);
        }
        for (int kind = 0; kind < kinds.length; kind++) {
            for (int money = kinds[kind]; money <= target; money++) {
                res[money] += res[money - kinds[kind]];
            }
        }
        System.out.println(res[target]);
    }
}
