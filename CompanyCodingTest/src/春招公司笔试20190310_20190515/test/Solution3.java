package 春招公司笔试20190310_20190515.test;

import java.util.*;

/**
 * @author tankInternshipInterview
 * @create 2019/03/03 21:24
 */
public class Solution3 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] minPath = new int[n][n];
        //边界条件
        for(int i = 0; i < n; i++){
            minPath[n - 1][i] = (triangle.get(n - 1).get(i));
        }
        for(int layer = n - 2; layer >= 0; layer--){
            // 从底向上，n-2层开始
            for(int j = 0; j <= layer; j++){
                minPath[layer][j] = triangle.get(layer).get(j) + Math.min(minPath[layer + 1][j], minPath[layer + 1][j + 1]);
            }
        }
        return minPath[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);list3.add(5);list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);list4.add(1);list4.add(8);list4.add(3);
        res.add(list1);
        res.add(list2);
        res.add(list3);
        res.add(list4);
        int a = minimumTotal(res);
        System.out.println(a);
    }
}
