import java.util.Scanner;
public class tong_ji_man_zu_tiao_jian_de_shu_zi {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int count = 0;
        if(num1 <= num2) {
            for(int i = num1; i <= num2; i++) {
                if(i % 3 == 0 && i % 5 == 0){
                    count++;
                }
            }
        } else{
            for(int i = num2; i <= num1; i++) {
                if(i % 3 == 0 && i % 5 == 0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
