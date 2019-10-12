package 秋招公司笔试20190727_20190921.pdd20190925;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/25 15:35
 */
public class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n + m];
        for (int i = 0; i < n; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            arr[i] = 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(result, temp, arr, 0);
        List<Integer> integers = result.get(k);
        for(int i : integers){
            if (i == 1) {
                System.out.print('a');
            }else{
                System.out.println('b');
            }
        }
    }

    private static void dfs(List<List<Integer>> result, List<Integer> temp, int[] arr, int i) {
        result.add(new ArrayList<>(temp));
        for (int j = i; j < arr.length; j++) {
            temp.add(arr[j]);
            dfs(result, temp, arr, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
