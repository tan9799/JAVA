import java.util.Scanner;
public class zi_fu_chuan_fen_li {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入任意字符串：");
        String str = sc.next();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.print(c);
            if((i + 1) % 8 == 0) {
                System.out.println();
            }
        }
        for(int j = 0; j < 8 - str.length() % 8; j++) {
            System.out.print("0");
        }
    }
}
