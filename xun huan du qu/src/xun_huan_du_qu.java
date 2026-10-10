import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class xun_huan_du_qu {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("myio\\a.txt");
        int b;
        while((b = fis.read()) != -1) {
            System.out.println((char)b);
        }
        fis.close();
    }
}
