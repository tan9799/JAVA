import java.io.File;
import java.io.IOException;

public class wenjian {
    public static void main(String[] args) {
        File f = new File("d:\\a.txt");
        try {
            if (f.exists())
                f.delete();
            else {
                f.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
