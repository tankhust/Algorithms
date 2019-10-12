package 秋招公司笔试20190727_20190921.拼多多笔试20190901;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/01 14:52
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int i = str.indexOf(";");
        String numStr = str.substring(0, i);
        String[] numStrr = numStr.split(",");
        int[] nums = new int[numStrr.length];
        for (int j = 0; j < nums.length; j++) {
            nums[j] = Integer.valueOf(numStrr[j]);
        }
        int N = Integer.valueOf(str.substring(i + 1));

        int[] res = new int[N];
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                queue1.add(nums[j]);
            }else{
                queue2.add(nums[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(!queue1.isEmpty()) {
            if (cnt < N) {
                sb.append(queue1.poll() + ",");
                cnt++;
            }else{
                break;
            }
        }
        while(cnt++ < N) {
            sb.append(queue2.poll() + ",");
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }
}
