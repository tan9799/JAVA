import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class jmu_Java_02基本语法_03_身份证排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ids.add(sc.nextLine());
        }
        while (true) {
            String cmd = sc.nextLine();
            if (cmd.equals("sort1")) {
                List<String> sorted = new ArrayList<>(ids);
                sorted.sort(Comparator.comparing(id -> id.substring(6, 14)));
                for (String id : sorted) {
                    String birth = id.substring(6, 14);
                    String date = birth.substring(0, 4) + "-" + birth.substring(4, 6) + "-" + birth.substring(6, 8);
                    System.out.println(date);
                }
            } else if (cmd.equals("sort2")) {
                List<String> sorted = new ArrayList<>(ids);
                sorted.sort(Comparator.comparing(id -> id.substring(6, 14)));
                for (String id : sorted) {
                    System.out.println(id);
                }
            } else {
                System.out.println("exit");
                break;
            }
        }
        sc.close();
    }
}

