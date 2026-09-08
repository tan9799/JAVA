import java.util.Scanner;
public class VariableDemo2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请键盘录入一个整数：");
        int num1 = sc.nextInt();
        System.out.println("请键盘录入一个整数：");
        int num2 = sc.nextInt();
        int sum = num1 + num2;
        System.out.println(sum);

    }
}
