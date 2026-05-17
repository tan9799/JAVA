import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        String username = "admin";
        String password = "123";

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");

        String uname = sc.nextLine();

        System.out.println("请输入密码：");

        String upwd = sc.nextLine();

        //判断用户名和密码是否ok，用equals来判断
        if(uname.equals(username) && upwd.equals(password)) {
            System.out.println("登录成功");
        } else {
            System.out.println("登陆失败");
        }
    }
}

