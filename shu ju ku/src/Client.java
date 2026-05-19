import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("请问你要链接的数据库是哪个（1.Mysql； 2.Oracle）；");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        IDAO dao;
        if(n == 1){
            dao = new MySqlDao();
        } else {
            dao = new OracleDao();
        }
        dao.connect();
        dao.add();
        dao.del();
        dao.upd();
        dao.sel();
    }
}
