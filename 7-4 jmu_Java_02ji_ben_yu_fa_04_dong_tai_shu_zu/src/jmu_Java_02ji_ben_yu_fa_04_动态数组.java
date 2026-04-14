import java.util.Arrays;
import java.util.Scanner;
public class jmu_Java_02ji_ben_yu_fa_04_动态数组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            String[][] table = new String[n][];
            for (int i = 1; i <= n; i++) {
                table[i - 1] = new String[i];
                StringBuilder line = new StringBuilder();
                for (int j = 1; j <= i; j++) {
                    String expr = i + "*" + j + "=" + (i * j);
                    table[i - 1][j - 1] = expr;
                    if (j < i) {
                        line.append(String.format("%-7s", expr));
                    } else {
                        line.append(expr);
                    }
                }
                System.out.println(line);
            }
            System.out.println(Arrays.deepToString(table));
        }
        sc.close();
    }
}
