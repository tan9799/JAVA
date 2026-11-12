import java.io.FileOutputStream;
import java.io.IOException;

public class zi_jie_liu {
    public static void main(String[] args) throws IOException {
        //1.创建对象
        FileOutputStream fos = new FileOutputStream("mtio\\a.txt");
        //2.写出数据
        fos.write(97);
        //3.释放资源
        fos.close();
    }
}
