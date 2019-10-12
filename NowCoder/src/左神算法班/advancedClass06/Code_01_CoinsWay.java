package 左神算法班.advancedClass06;

import java.util.HashMap;

public class Code_01_CoinsWay {//还钱的方法数

	public static int coins1(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		return process1(arr, 0, aim);
	}

	//int[] arr:不变的变量，面试数组
	//index：可以任意自由使用index及其之后的钱，每个index代表的钱不一样
	//aim:目标钱数
	//返回值：方法数
	//可以认为是一种dfs搜索
	//是一种暴力递归的解，因为有很多剩的钱一样的情况
	public static int process1(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;//找到最后一张，剩钱为0时，有一种方法
		} else {
			for (int i = 0; arr[index] * i <= aim; i++) {//i为张数
				res += process1(arr, index + 1, aim - arr[index] * i);//index+1:下面的货币，aim - arr[index] * i:剩下的钱
			}
		}
		return res;
	}

	//key:index_aim
	//value:返回值
	//记忆化搜索
	public static HashMap<String, Integer> map = new HashMap<>();

	public static int process_map(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;//找到最后一张，剩钱为0时，有一种方法
		} else {
			for (int i = 0; arr[index] * i <= aim; i++) {//i为张数
				int nextAim = aim - arr[index] * i;
				String key = String.valueOf(index + 1) + "_" + String.valueOf(nextAim);
				if (map.containsKey(key)) {
					res += map.get(key);
				} else {
					res += process_map(arr, index + 1, nextAim);//index+1:下面的张数，aim - arr[index] * i:剩下的钱
				}
			}
		}
		map.put(String.valueOf(index) + "_" + String.valueOf(aim), res);
		return res;
	}



	public static int coinsOther(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		return processOther(arr, arr.length - 1, aim);
	}

	public static int processOther(int[] arr, int index, int aim) {
		int res = 0;
		if (index == -1) {
			res = aim == 0 ? 1 : 0;
		} else {
			for (int i = 0; arr[index] * i <= aim; i++) {
				res += processOther(arr, index - 1, aim - arr[index] * i);
			}
		}
		return res;
	}

	public static int coins2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] map = new int[arr.length + 1][aim + 1];
		return process2(arr, 0, aim, map);
	}

	public static int process2(int[] arr, int index, int aim, int[][] map) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			int mapValue = 0;
			for (int i = 0; arr[index] * i <= aim; i++) {
				mapValue = map[index + 1][aim - arr[index] * i];
				if (mapValue != 0) {
					res += mapValue == -1 ? 0 : mapValue;
				} else {
					res += process2(arr, index + 1, aim - arr[index] * i, map);
				}
			}
		}
		map[index][aim] = res == 0 ? -1 : res;
		return res;
	}

	public static int coins3(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length][aim + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; arr[0] * j <= aim; j++) {
			dp[0][arr[0] * j] = 1;
		}
		int num = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				num = 0;
				for (int k = 0; j - arr[i] * k >= 0; k++) {
					num += dp[i - 1][j - arr[i] * k];
				}
				dp[i][j] = num;
			}
		}
		return dp[arr.length - 1][aim];
	}

	public static int coins4(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length][aim + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; arr[0] * j <= aim; j++) {
			dp[0][arr[0] * j] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[i][j] = dp[i - 1][j];
				dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
			}
		}
		return dp[arr.length - 1][aim];
	}

	public static int coins5(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[] dp = new int[aim + 1];
		for (int j = 0; arr[0] * j <= aim; j++) {
			dp[arr[0] * j] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
			}
		}
		return dp[aim];
	}

	public static void main(String[] args) {
		int[] coins = { 10, 5, 1, 25 };
		int aim = 2000;

		long start = 0;
		long end = 0;
		start = System.currentTimeMillis();
		System.out.println(coins1(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		start = System.currentTimeMillis();
		System.out.println(coinsOther(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		aim = 20000;

		start = System.currentTimeMillis();
		System.out.println(coins2(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		start = System.currentTimeMillis();
		System.out.println(coins3(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		start = System.currentTimeMillis();
		System.out.println(coins4(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		start = System.currentTimeMillis();
		System.out.println(coins5(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

	}

}
