import java.util.Scanner;

public class zi_fu_chuan_zheng_shu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                // 如果当前是数字，且前一个字符不是数字（或i==0），则先加星号
                if (i == 0 || !(str.charAt(i - 1) >= '0' && str.charAt(i - 1) <= '9')) {
                    sb.append('*');
                }
                sb.append(c);
                // 如果下一个字符不是数字（或已到末尾），则加星号
                if (i == str.length() - 1 || !(str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9')) {
                    sb.append('*');
                }
            } else {
                // 非数字直接添加
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}