import java.util.Scanner;
public class ji_suan_kuai_di_you_fei {
    public static void main(String args[]) {
        System.out.println("请输入快递重量：");
        Scanner sc = new Scanner(System.in);
        double weight = 0.0;
        while(true) {
            double a = sc.nextDouble();
            if(a > 0.0) {
                weight = a;
                break;
            } else {
                System.out.println("请输入正确的重量！");
            }
        }
        System.out.println("快递价格：" + price(weight));
    }
    public static double price(double weight) {
        if(weight <= 1.0) {
            return 10.0;
        } else if (weight <= 5) {
            if(weight % 1 == 0) {
                return 10.0 + (weight - 1) * 2.0;
            } else {
                return 10.0 + (int)weight * 2.0;
            }
        } else {
            if(weight % 1 == 0) {
                return 18.0 + (weight - 5) * 1.5;
            } else {
                return 18.0 + (int)(weight - 4) * 1.5;
            }
        }
    }
}
