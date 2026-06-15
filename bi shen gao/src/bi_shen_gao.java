import java.util.Scanner;
public class bi_shen_gao {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double you = sc.nextDouble();
        double friend = sc.nextDouble();
        if(you > friend) {
            System.out.println("你高");
        }
        else if (you < friend) {
            System.out.println("朋友高");
        }
        else{
            System.out.println("你们身高一样");
        }
        /*还有一种写法：
        boolean result = you > friend;
        System.out.println(result ? "你高" : "朋友高");
         */
    }
}
