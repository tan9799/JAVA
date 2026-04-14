import java.util.Scanner;
public class jmu_Java_02ji_ben_yu_fa_02_StringBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (!sc.hasNextInt()) break;
            int begin = sc.nextInt();
            if (!sc.hasNextInt()) break;
            int end = sc.nextInt();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(i);
            }
            String str = sb.toString();
            System.out.println(str.substring(begin, end));
        }
        sc.close();
    }
}
