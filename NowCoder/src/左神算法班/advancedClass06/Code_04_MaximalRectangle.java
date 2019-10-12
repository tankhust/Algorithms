package 左神算法班.advancedClass06;

import java.util.Stack;

public class Code_04_MaximalRectangle {//求最大子矩阵的大小

	public static int maxRecSize(int[][] map) {
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}

	//[4,3,2,5,6]
	// | | | | |
	// 0,1,2,3,4

	public static int maxRecFromBottom(int[] height) {//从底算起矩阵的最大面积
		if (height == null || height.length == 0) {
			return 0;
		}
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();//存数据下标
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {//当前栈不为空且当前值小于栈顶的值
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();//k为左边界
				int curArea = (i - k - 1) * height[j];//i为右边界，curArea为以j为下标，能够扩出来的矩型面积最大值
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		//数据压完后，结算栈中剩下的元素
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[][] map = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 }, };
		System.out.println(maxRecSize(map));
	}

}
