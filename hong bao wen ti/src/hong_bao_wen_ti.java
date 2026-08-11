import java.util.Scanner;
import java.util.Random;
public class hong_bao_wen_ti {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int M = sc.nextInt();
        int N = sc.nextInt();
        int remainMoney = M;
        int remainPeople = N;
        if(M < N) {
            System.out.println("红包金额不足");
        } else {
            for(int i = 0; i < N - 1; i++) {
                int max = remainMoney - (remainPeople - 1);
                int amount = r.nextInt(max) + 1;
                System.out.println(amount);
                remainMoney -= amount;
                remainPeople--;
            }
            System.out.println(remainMoney);
        }
    }
}
