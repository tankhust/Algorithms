package 秋招公司笔试20190727_20190921.拼多多笔试20190901;

import java.util.*;

/**
 * @author tankInternshipInterview
 * @create 2019/09/01 14:52
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
//        List<Integer> res = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                res.add(i * j);
//            }
//        }
//        Collections.sort(res);
//        System.out.println(res.get(n * m - k));
        PriorityQueue queue = new PriorityQueue(Collections.reverseOrder());
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                queue.add(i * j);
            }
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        System.out.println(queue.peek());
    }
}
