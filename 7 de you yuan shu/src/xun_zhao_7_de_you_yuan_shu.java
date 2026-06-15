import java.util.Scanner;
public class xun_zhao_7_de_you_yuan_shu {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int gewei = num % 10;
        int shiwei = num / 10;
        boolean result = gewei == 7 || shiwei == 7 || num % 7 == 0;
        System.out.println(result);
    }
}
