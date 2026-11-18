import java.util.Scanner;
public class zi_mu_da_xiao_xie_zhuan_huan {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char zimu = sc.next().charAt(0);  // 从字符串中取出第一个字符
        char str2 = (char)(zimu + 32);
        System.out.println(str2);
    }
}
