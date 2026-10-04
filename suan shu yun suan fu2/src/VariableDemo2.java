import java.util.Scanner;
public class VariableDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int baiwei = num / 100;
        int shiwei = num / 10 % 10;
        int gewei = num % 10;
        System.out.println(gewei);
        System.out.println(shiwei);
        System.out.println(baiwei);
    }
}
