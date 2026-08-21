import java.util.Scanner;
public class liang_shu_he_fang_fa {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(getSum(a, b));
    }
    public static int getSum(int a, int b) {
        return a + b;
    }
}
