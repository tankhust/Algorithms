package 秋招公司笔试20190727_20190921.Shopee笔试题20190727_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 对一个单链表去重，如果链表中有重复的项，则删除第二项及以后的项，需要对原链表保持顺序
 *
 * 输入 1 2 5 7 2 1 3 3 9
 * 输出 1 2 5 7 3 9
 *
 * @author tankInternshipInterview
 * @create 2019/07/27 19:30
 */
public class 单链表去重 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4,5,8,7,13,6};
        System.out.println(Arrays.toString(new 单链表去重().deleteSame(arr)));
    }

    private int[] deleteSame(int[] arr) {

        if(arr == null || arr.length == 0)
            return arr;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }
        Object[] objects = list.toArray();
        int[] res = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            res[i] = Integer.valueOf((Integer)objects[i]);
        }
        return res;
    }
}
