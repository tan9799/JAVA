import java.util.Scanner;
public class shang_san_jiao_shu_zi_san_jiao_xing {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int number = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++) {
                System.out.printf("%4d", number);
                number += 1;
            }
            System.out.println();
        }
    }
}
