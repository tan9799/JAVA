import java.io.FileInputStream;
import java.io.IOException;

public class wenjian {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("d:\\a.txt")) {
            byte[] buffer = new byte[58];
            int bytesRead = fis.read(buffer);   // 实际读取的字节数
            if (bytesRead > 0) {
                // 只打印实际读取的部分
                for (int i = 0; i < bytesRead; i++) {
                    System.out.println(buffer[i]);
                }
            } else {
                System.out.println("文件为空或读取失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
