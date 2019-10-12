package 左神算法班.basicClass04;

public class Code_06_IsBalancedTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isBalance(Node head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 1, res);
		return res[0];
	}

	public static int getHeight(Node head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}
		int lH = getHeight(head.left, level + 1, res);
		if (!res[0]) {
			return level;
		}
		int rH = getHeight(head.right, level + 1, res);
		if (!res[0]) {
			return level;
		}
		if (Math.abs(lH - rH) > 1) {
			res[0] = false;
		}
		return Math.max(lH, rH);
	}

	static class Solution{
		public boolean IsBalanced_Solution(Node root){
			return getHeight(root) != -1;
		}
		public int getHeight(Node root){
			if(root==null) return 0;
			int left=getHeight(root.left);
			if(left==-1)return -1;
			int right = getHeight(root.right);
			if(right==-1)return -1;
			return Math.abs(left - right) > 1 ? -1 : Math.max(left, right);
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		System.out.println(isBalance(head));
		System.out.println("---------------");
		Solution solution = new Solution();
		System.out.println(solution.IsBalanced_Solution(head));
	}

}
