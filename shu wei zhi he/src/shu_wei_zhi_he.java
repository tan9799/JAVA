import java.util.Scanner;
public class shu_wei_zhi_he {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        if(num > 0) {
            while(num > 0) {
                sum += num % 10;
                num = num / 10;
            }
        } else {
            num = -num;
            while(num > 0) {
                sum += num % 10;
                num = num / 10;
            }
        }
        System.out.println(sum);
    }
}
