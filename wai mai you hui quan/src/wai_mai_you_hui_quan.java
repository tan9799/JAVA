import java.util.Scanner;
public class wai_mai_you_hui_quan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        double baoleme = num * 0.9;
        double meidan = num - 10 * (int)(num / 30);
        if(baoleme >= meidan) {
            System.out.println("在美单买，价格是" + meidan);
        } else {
            System.out.println("在饱了么买，价格是" + baoleme);
        }
    }
}
