import java.util.Scanner;
public class xi_an_ju_li {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int distance = Math.abs(a - c) + Math.abs(b - d);
        System.out.println(distance);
    }
}
