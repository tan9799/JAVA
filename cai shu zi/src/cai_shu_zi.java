import java.util.Random;
import java.util.Scanner;
public class cai_shu_zi {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        Random r = new Random();
        int num = r.nextInt(1,101);
        int guess = sc.nextInt();
        while(num != guess) {
            if(count == 9) {
                break;
            }
            count++;
            if(guess > num) {
                System.out.println("你猜的数字太大了！请重新输入数字：");
            } else if (guess < num){
                System.out.println("你猜的数字太小了！请重新输入数字：");
            } else {
                break;
            }
            int shangxian = num + 5;
            int xiaxian = num - 5;
            if(count >= 3) {
                System.out.println("随机数范围在："+ xiaxian + "~" + shangxian + "之间，请重新输入数字：");
            }

            guess = sc.nextInt();
        }
        System.out.println("恭喜你猜对了！");
    }
}
