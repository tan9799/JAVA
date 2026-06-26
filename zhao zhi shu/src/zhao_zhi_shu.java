import java.util.Scanner;
public class zhao_zhi_shu {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int flag = 0;
        while(true) {
            System.out.println("请输入一个整数：");
            num = sc.nextInt();
            if(num >= 2) {
                break;
            } else {
                System.out.println("请输入一个大于等于2的整数：");
            }
        }
        for(int i = 2; i < Math.sqrt(num); i++) {
            if(num % i == 0) {
                flag = 1;
                break;
            }
        }
        if(flag == 1) {
            System.out.println("不是质数");
        } else {
            System.out.println("是质数");
        }
    }
}
