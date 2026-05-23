import java.io.*;
public class wenjian {
    public static void main(String[] args) {
        File f1=new File("d:\\a.txt");
        File f2=new File("d:\\b.txt");
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis=new FileInputStream(f1);
            fos=new FileOutputStream(f2,true);
            int t=0;
            while((t=fis.read())!=-1)
                fos.write(t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis!=null) fis.close();
                if(fos!=null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
