import java.util.*;

public class tou_piao_tong_ji_xi_tong  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> votes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            switch (command) {
                case "VOTE":
                    String name = parts[1];
                    votes.put(name, votes.getOrDefault(name, 0) + 1);
                    System.out.println("Voted for " + name);
                    break;
                case "QUERY":
                    String queryName = parts[1];
                    if (votes.containsKey(queryName)) {
                        System.out.println(queryName + " : " + votes.get(queryName));
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case "LIST":
                    if (votes.isEmpty()) {
                        break;
                    }
                    List<Map.Entry<String, Integer>> list = new ArrayList<>(votes.entrySet());
                    list.sort((a, b) -> {
                        if (!a.getValue().equals(b.getValue())) {
                            return b.getValue() - a.getValue(); // 票数降序
                        } else {
                            return a.getKey().compareTo(b.getKey()); // 名字升序
                        }
                    });
                    for (Map.Entry<String, Integer> entry : list) {
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                    }
                    break;
                default:
                    // 无效命令
                    break;
            }
        }
        scanner.close();
    }
}