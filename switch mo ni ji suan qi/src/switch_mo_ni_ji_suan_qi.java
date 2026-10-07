import java.util.Scanner;
public class switch_mo_ni_ji_suan_qi {
    public static void main(String args[]) {
        int a = 10;
        int b = 20;
        Scanner sc = new Scanner(System.in);
        String operator = sc.next();
        int result = switch(operator) {
            case "+" -> {
                int sum = a + b;
                yield sum;
            }
            case "-" -> {
                int sub = a - b;
                yield sub;
            }
            case "*" -> {
                int mul = a * b;
                yield mul;
            }
            case "/" -> {
                int div = a / b;
                yield div;
            }
            default -> {
                System.out.println("Invalid operator");
                yield 0;
            }
        };
        System.out.println(result);
    }
}
