package 春招公司笔试20190310_20190515.basicClass;

public class Code_28_Hanoi {//汉诺塔问题
    public static void hanoi(int n) {
        if (n > 0) {
            hanoiCore(n,"left","right","mid");
        }
    }

    public static void hanoiCore(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            hanoiCore(n - 1, from, help, to);
            System.out.println("Move " + n + " from " + from + " to " + to);
            hanoiCore(n - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        hanoi(3);

    }

}

