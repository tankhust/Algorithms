package 牛油面试手撕;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Fisher-Yates Shuffle算法
 * @author tankInternshipInterview
 * @create 2019/08/04 17:13
 */
public class 洗牌算法 {
    private Random random = new Random();
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        洗牌算法 solution = new 洗牌算法();
        init(n);
        print(arr);
        solution.shuffle();
        print(arr);
    }

    private static void init(int n) {
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    private void shuffle() {
        for (int i = arr.length - 1; i >= 0; i--) {
            int rand = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[rand];
            arr[rand] = temp;
        }
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
