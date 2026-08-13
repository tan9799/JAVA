import java.util.Scanner;

public class ji_suan_mou_ge_zi_fu_chu_xian_de_ci_shu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char c = sc.next().charAt(0);
        c = Character.toUpperCase(c);
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            char c1 = Character.toUpperCase(str.charAt(i));
            if(c1 == c) {
                count++;
            }
        }
        System.out.println(count);
    }
}
