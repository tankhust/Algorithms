package 秋招公司笔试20190727_20190921.Shopee笔试题20190727;

import java.util.Scanner;

/**
 * shopee的零食柜，有着各式各样的零食，但是因为贪吃，小虾同学体重日益增加，终于被人叫为小胖了，
 * 他终于下定决心减肥了，他决定每天晚上去操场跑两圈，但是跑步太累人了，他想转移注意力，忘记痛苦，
 * 正在听着音乐的他，突然有个想法，他想跟着音乐的节奏来跑步，音乐有7种音符，对应的是1到7，那么他
 * 对应的步长就可以是1-7分米，这样的话他就可以转移注意力了，但是他想保持自己跑步的速度，在规定时间
 * m分钟跑完。为了避免被累死，他需要规划他每分钟需要跑过的音符，这些音符的步长总和要尽量小。下面是
 * 小虾同学听的歌曲的音符，以及规定的时间，你能告诉他每分钟他应该跑多少步长？
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入的第一行输入 n（1 ≤ n ≤ 1000000，表示音符数），m（1<=m< 1000000, m <= n）组成，
 * <p>
 * 第二行有 n 个数，表示每个音符（1<= f <= 7）
 * <p>
 * 输出描述:
 * 输出每分钟应该跑的步长
 * <p>
 * 输入例子1:
 * 8 5
 * 6 5 6 7 6 6 3 1
 * <p>
 * 输出例子1:
 * 11
 * <p>
 * 例子说明1:
 * 6 | 5 6 | 7 | 6 | 6 3 1  为最优解
 * <p>
 * 如果小于11，必然分段大于5
 *
 * @author tankInternshipInterview
 * @create 2019/07/27 12:53
 */
public class Shopee的零食柜 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int sumSteps = 0;// 总步长，步长为sum时，步长最小，1
        int maxStep = 0;// 最大的音符数字，步长为maxNum时，步数为最大，n
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr[i] = temp;
            sumSteps += temp;
            maxStep = Math.max(maxStep, temp);
        }
        int l = maxStep, r = sumSteps, ans = l, mid = 0;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (judge(arr, mid, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.print(mid);

        // 这种不对
//        int l = maxStep, r = sumSteps, ans = l, mid = 0;
//        while (l < r) {
//            mid = l + ((r - l) >> 1);
//            if (judge(arr, mid, m)) {
//                r = mid;
//                ans = Math.max(ans, mid);
//            } else {
//                l = mid + 1;
//            }
//        }
//        System.out.print(ans);
    }

    private static boolean judge(int[] arr, int stepLen, int segments) {
        // subNums为分段数
        int curSteps = 0;// 当前一段内步数
        int curSegments = 1;// 当前段数
        int i;
        for (i = 0; i < arr.length; i++) {
            curSteps += arr[i];
            if (curSteps > stepLen) {
                curSegments++;
                curSteps = arr[i];// 更新当前步数
            }
            if (curSegments > segments)
                break;
        }
        return i == arr.length;// stepLen满足要求
    }
}
