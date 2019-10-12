package 左神算法班.advancedClass07;

import java.util.ArrayList;

public class Code_04_MaxHappy {//公司上下级，最大活跃值

	public static int maxHappy(int[][] matrix) {
		int[][] dp = new int[matrix.length][2];
		boolean[] visited = new boolean[matrix.length];
		int root = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (i == matrix[i][0]) {
				root = i;
			}
		}
		process(matrix, dp, visited, root);
		return Math.max(dp[root][0], dp[root][1]);
	}

	public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
		visited[root] = true;
		dp[root][1] = matrix[root][1];
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == root && !visited[i]) {
				process(matrix, dp, visited, i);
				dp[root][1] += dp[i][0];
				dp[root][0] += Math.max(dp[i][1], dp[i][0]);
			}
		}
	}

	//method2 coding by tankInternshipInterview
	public static int getMaxHuo(Node head) {
		return Math.max(process(head).lai_huo,process(head).bu_lai_huo);
	}


	public static class Node {
		public int huo;
		public ArrayList<Node> nexts;

		public Node(int huo,ArrayList<Node> nexts) {
			this.huo=huo;
			this.nexts=nexts;
		}
	}

	public static class ReturnType {
		public int lai_huo;
		public int bu_lai_huo;

		public ReturnType(int lai_huo, int bu_lai_huo) {
			this.lai_huo = lai_huo;
			this.bu_lai_huo = bu_lai_huo;
		}
	}

	public static ReturnType process(Node head) {
		int lai_huo=head.huo;
		int bu_lai_huo=0;

		for (int i = 0; i < head.nexts.size(); i++) {

			ReturnType p1=process(head.nexts.get(i));
			lai_huo+=p1.bu_lai_huo;
			bu_lai_huo += Math.max(p1.lai_huo, p1.bu_lai_huo);
		}
		return new ReturnType(lai_huo, bu_lai_huo);
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
		System.out.println(maxHappy(matrix));
	}
}
