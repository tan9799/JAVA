import java.util.Scanner;
public class shu_lie_zhi_he {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        for(int i = 1; i <= num; i++){
            if(i % 2 == 0) {
                sum += -1 * i;
            } else {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
