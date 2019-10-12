package 左神算法班.advancedClass05;

public class Code_05_Max_EOR {//求子数组的最大异或和 异或和第一位为符号为，期望为0

	public static int  getEorMax1(int[] arr) {//暴力解,O(n^3)
		int max=Integer.MIN_VALUE;
		int eor=0;
		for (int i = 0; i < arr.length; i++) {
			for (int start = 0; start <= i; start++) {
				for (int j = start; j <= i; j++) {
					eor^=arr[j];
				}
				max = Math.max(eor, max);
				eor = 0;
			}
		}
		return max;
	}

	public static int getEorMax2(int[] arr) {//dp解，O(n^2)
		int max=Integer.MIN_VALUE;
		int[] dp = new int[arr.length];
		int eor=0;
		for (int i = 0; i < arr.length; i++) {
			eor^=arr[i];//0..i
			max = Math.max(max, eor);
			dp[i] = eor;
			for (int start = 1; start < i; start++) {
				int startToI=eor^dp[start-1];//start....i
				max = Math.max(max, startToI);
			}
		}
		return max;
	}






	public static class Node {
		public Node[] nexts = new Node[2];//0,1
	}

	public static class NumTrie {
		public Node head = new Node();

		public void add(int num) {
			Node cur = head;
			for (int move = 31; move >= 0; move--) {
				int path = ((num >> move) & 1);
				cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
				cur = cur.nexts[path];
			}
		}

		public int maxXor(int num) {
			Node cur = head;
			int res = 0;
			for (int move = 31; move >= 0; move--) {
				int path = (num >> move) & 1;
				//如果当前位是符号位，期望符号位为0，希望best与path一样，异或为0，为正
				//不是符号位，期望为1，希望best与path不一样，这里求出期待选的路
				int best = move == 31 ? path : (path ^ 1);
				best = cur.nexts[best] != null ? best : (best ^ 1);//best可能有，可能没有，这里求出实际要选的路
				res |= (path ^ best) << move;//设置答案的每一位
				cur = cur.nexts[best];//继续往下走
			}
			return res;
		}

	}

	public static int maxXorSubarray(int[] arr) {//用前缀树解，O(n)
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int eor = 0;
		NumTrie numTrie = new NumTrie();
		numTrie.add(0);
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
			max = Math.max(max, numTrie.maxXor(eor));
			numTrie.add(eor);
		}
		return max;
	}

	// for test
	public static int comparator(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int eor = 0;
			for (int j = i; j < arr.length; j++) {
				eor ^= arr[j];
				max = Math.max(max, eor);
			}
		}
		return max;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 30;
		int maxValue = 50;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			int res = maxXorSubarray(arr);
			int comp = comparator(arr);
			if (res != comp) {
				succeed = false;
				printArray(arr);
				System.out.println(res);
				System.out.println(comp);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}
}
