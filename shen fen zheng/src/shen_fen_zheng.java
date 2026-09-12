import java.util.Scanner;

public class shen_fen_zheng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String birth = n.substring(6, 14);
        String year = birth.substring(0, 4);
        String month = birth.substring(4, 6);
        String day = birth.substring(6, 8);
        String birthDate = year + "年" + month + "月" + day + "日";
        char genderChar = n.charAt(16); // '3'
        int genderNum = genderChar - '0';
        String gender = (genderNum % 2 == 1) ? "男" : "女";

        // 3. 输出结果
        System.out.println("出生年月日：" + birthDate);
        System.out.println("性别为：" + gender);
    }
}
