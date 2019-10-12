package 左神算法班.basicClass08;

import java.util.LinkedList;

public class Code_03_SlidingWindowMaxArray {

	public static int[] getMaxWindow(int[] arr, int w) {//获取最大窗口
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();//存当前在窗口中的值的下标
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {//要新加进来的数大于等于窗口尾部就干掉直到没数
				qmax.pollLast();
			}
			qmax.addLast(i);//把要新加进来的数加进来
			if (qmax.peekFirst() == i - w) {//初始形成W大小窗口前，只在后面加；形成窗口后，后面加，前面如果过期就减，没过期就不变（过期弹出）
				qmax.pollFirst();
			}
			if (i >= w - 1) {//形成W大小窗口后（此条件只在形成窗口前不成立，往后都成立），将当前最大值取出
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}

	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
		int w = 3;
		printArray(getMaxWindow(arr, w));

	}

}
