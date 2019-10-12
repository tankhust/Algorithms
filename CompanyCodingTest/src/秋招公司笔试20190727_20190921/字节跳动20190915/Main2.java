package 秋招公司笔试20190727_20190921.字节跳动20190915;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/15 16:24
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Long,Long> map = new HashMap<>();
        long[] times = new long[n];
        for (int i = 0; i < n; i++) {
            long t = sc.nextInt();
            long c = sc.nextInt();
            times[i] = t;
            map.put(t, c);
        }
        Arrays.sort(times);
        long maxFiles = map.get(times[0]);
        long fileLeft = maxFiles;
        for (int i = 1; i < n; i++) {
            long tempPeriod = times[i] - times[i - 1];
            if(fileLeft >= tempPeriod)// 说明中间一直在传文件
                fileLeft = fileLeft + map.get(times[i]) - tempPeriod;
            else
                fileLeft = map.get(times[i]);
            maxFiles = Math.max(fileLeft,maxFiles);
        }
        long lastTime = times[n - 1];
        long end = fileLeft+lastTime;
        System.out.print(end + " ");
        System.out.println(maxFiles);
    }
}
