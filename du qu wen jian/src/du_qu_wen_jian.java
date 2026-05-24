import java.io.*;
import java.util.Scanner;
public class du_qu_wen_jian {
    public static void main(String[] args) {
        String filename = "B.txt";
        Scanner scanner = new Scanner(System.in);
        double[] doubles = new double[10];
        System.out.println("请输入10个double数值（每行一个或空格分隔）：");
        for (int i = 0; i < 10; i++) {
            if (scanner.hasNextDouble()) {
                doubles[i] = scanner.nextDouble();
            } else {
                System.out.println("输入无效，使用默认值0.0");
                doubles[i] = 0.0;
            }
        }
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            for (double d : doubles) {
                raf.writeDouble(d);
            }
            System.out.println("已写入10个double数据到文件 " + filename);
            long insertPos = 4 * 8;
            raf.seek(insertPos);
            byte[] remaining = new byte[(int)(raf.length() - insertPos)];
            raf.read(remaining);
            raf.seek(insertPos);
            System.out.print("请输入要插入的整数: ");
            int num = scanner.nextInt();
            raf.writeInt(num);
            raf.write(remaining);
            System.out.println("在第4个数据后插入整数 " + num + " 完成。");
            raf.seek(0);
            System.out.println("文件内容：");
            for (int i = 0; i < 4; i++) {
                System.out.println("double[" + i + "] = " + raf.readDouble());
            }
            System.out.println("插入的整数: " + raf.readInt());
            for (int i = 0; i < 6; i++) {
                System.out.println("double[" + (i+4) + "] = " + raf.readDouble());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}