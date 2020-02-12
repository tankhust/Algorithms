import java.util.Scanner;

/**
 * @author tank
 * @create 2019/10/30 15:50
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int temp = 0;
        StringBuilder result = new StringBuilder();
        while(n != 0){
            temp = n % 10;
            result.append(temp);
            n = (n - temp) / 10;
        }
        System.out.print(result);
    }
}
