import java.util.*;

public class jmu_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new TreeSet<>(); // 自动按字典序排序
        while (true) {
            String line = sc.nextLine();
            if (line.equals("!!!!!")) {
                break;
            }
            if (line.trim().isEmpty()) {
                continue; // 忽略空行
            }
            String[] words = line.split("\\s+"); // 按空格分割，可能多个空格
            for (String word : words) {
                set.add(word);
            }
        }
        int size = set.size();
        System.out.println(size);
        int count = 0;
        for (String word : set) {
            System.out.println(word);
            count++;
            if (count >= 10) break;
        }
    }
}