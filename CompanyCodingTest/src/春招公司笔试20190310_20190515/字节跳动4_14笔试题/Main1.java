package 春招公司笔试20190310_20190515.字节跳动4_14笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/04/14 9:56
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        backTracing(arr,0, list, res, visited);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size(); i++) {
            int temp = 0;
            for (int j = 0; j <= n; j++) {
                temp += res.get(i).get(j);
            }
            min = Math.min(min, temp);
        }
        System.out.println(min);
    }

    private static void backTracing(int[][] arr, int start, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if(list.size() == arr.length){
            List<Integer> temp = new ArrayList<>(list);
            temp.add(arr[start][0]);
            res.add(temp);
            return;
        }
        for(int i = 0; i < visited.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            list.add(arr[start][i]);
            backTracing(arr, i, list, res, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
