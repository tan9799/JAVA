import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("myio\\a.txt");
        String str = " adefjeavgberj";
        byte[] bytes = str.getBytes();
        fos.write(bytes);
        fos.close();
    }
}
