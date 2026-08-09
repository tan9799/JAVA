import java.io.FileInputStream;
import java.io.IOException;

public class MyInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("myio\\a.txt");
        int b1 = fis.read();
        System.out.println(b1);
        fis.close();
    }
}
