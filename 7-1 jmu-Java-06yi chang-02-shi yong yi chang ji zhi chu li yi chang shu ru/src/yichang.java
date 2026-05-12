import java.util.Arrays;
import java.util.Scanner;

public class yichang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗换行
        int[] arr = new int[n];
        int count = 0;
        while (count < n) {
            String line = scanner.nextLine();
            try {
                int num = Integer.parseInt(line);
                arr[count] = num;
                count++;
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
            }
        }
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}
