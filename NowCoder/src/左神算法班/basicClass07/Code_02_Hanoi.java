package 左神算法班.basicClass07;

public class Code_02_Hanoi {//汉诺塔问题

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, "left", "mid", "right");
		}
	}

	public static void func(int n, String from, String mid, String to) {
		if (n == 1) {
			System.out.println("move from " + from + " to " + to);
		} else {
			func(n - 1, from, to, mid);
			func(1, from, mid, to);
			func(n - 1, mid, from, to);
		}
	}

	//
	public static void process(int N, String from, String to, String help) {
		if (N == 1) {
			System.out.println("Move 1 from " + from + " to " + to);
		} else {
			process(N - 1, from, help, to);
			System.out.println("Move " + N + " from " + from + " to " + help);
			process(N - 1, help, to, from);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		/*hanoi(n);*/

		process(3, "左", "中","右" );
	}

}
