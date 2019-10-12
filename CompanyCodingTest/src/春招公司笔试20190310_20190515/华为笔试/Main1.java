package 春招公司笔试20190310_20190515.华为笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/05/08 19:21
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n件礼物
        int k = sc.nextInt();//k个小朋友
        List<String> res = new ArrayList<>();
        int a = n + k - 1;
        dfs(0, n, k - 1, a, "", res);
        System.out.println(res.size());
        for (String s : res) {
            System.out.println(s);
        }
    }

    private static void dfs(int index, int n, int k, int a, String path, List<String> res) {
        if (index == a) {
            res.add(new String(path));
            return;
        }
        if (n > 0) {
            dfs(index + 1, n - 1, k, a, path + "*", res);
        }
        if (k > 0) {
            dfs(index + 1, n, k - 1, a, path + "|", res);
        }
    }
}
