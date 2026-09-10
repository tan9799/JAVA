import java.util.Scanner;
public class VariableDemo3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的身高：");
        double height = sc.nextDouble();
        System.out.println("请输入你的体重：");
        double weight = sc.nextDouble();
        double BMI = weight / (height * height);
        System.out.println("BMI:"+ BMI);
    }
}
