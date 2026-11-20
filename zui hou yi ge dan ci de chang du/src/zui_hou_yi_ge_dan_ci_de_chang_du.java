import java.util.Scanner;

public class zui_hou_yi_ge_dan_ci_de_chang_du {
    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入字符串: ");
        String s = sc.nextLine();
        System.out.println("最后一个单词的长度: " + lengthOfLastWord(s));
    }
}