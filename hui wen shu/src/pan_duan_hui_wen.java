import java.util.Scanner;
public class pan_duan_hui_wen {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int qianwei = num / 1000;
        int baiwei = num % 1000 / 100;
        int shiwei = num % 1000 % 100 / 10;
        int gewei = num % 1000 % 100 % 10;
        boolean result = qianwei == gewei && baiwei == shiwei;
        System.out.println(result);
    }
}
