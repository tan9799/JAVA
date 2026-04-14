import java.util.Scanner;
public class jmu_Java_ru_men_qu_shu_zi_fu_dian_shu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            int sum = 0;
            for (char c : line.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    sum += (c - '0');
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
