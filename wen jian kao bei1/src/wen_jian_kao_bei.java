import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class wen_jian_kao_bei {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("myio\\a.txt");
        FileOutputStream fos = new FileOutputStream("myio\\copy.mp4");
        int b;
        while((b = fis.read()) != -1) {
            fos.write(b);
        }
        fos.close();
        fis.close();
        long endTime = System.currentTimeMillis();
        long lastime = endTime - startTime;
        System.out.println("复制完成，耗时：" + lastime + "毫秒");
    }
}
