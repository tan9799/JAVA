import java.util.Scanner;
public class zi_fu_chuan_fan_zhuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String str = sc.next();
            if(str.equals("拜拜")){
                break;
            } else {
                StringBuilder sb = new StringBuilder(str);
                sb.reverse();
                String res = sb.toString();
                System.out.println(res);
            }
        }
    }
}
