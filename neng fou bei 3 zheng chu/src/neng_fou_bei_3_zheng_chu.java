import java.util.Scanner;
public class neng_fou_bei_3_zheng_chu {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean result = num % 3 == 0;
        System.out.println(result);
    }
}
