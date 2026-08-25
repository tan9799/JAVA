import java.util.Scanner;
public class pan_duan_shu_zi_shi_fou_shi_zai_yi_dao_shi_zhi_jian {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num >= 1 & num <= 10){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
