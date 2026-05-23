import java.io.*;
import java.util.Scanner;
public class wen_jian_kao_bei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文件路径: ");
        String sourcePath = scanner.nextLine().trim();

        // 去除首尾可能存在的双引号
        if (sourcePath.startsWith("\"") && sourcePath.endsWith("\"")) {
            sourcePath = sourcePath.substring(1, sourcePath.length() - 1);
        }
        File sourceFile = new File(sourcePath);

        if (!sourceFile.exists()) {
            System.out.println("文件不存在！");
            return;
        }
        String parent = sourceFile.getParent();
        String name = sourceFile.getName();
        String destPath = parent + File.separator + "copy_" + name;
        File destFile = new File(destPath);

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[8192];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("文件复制成功！");
            System.out.println("目标文件: " + destPath);
        } catch (IOException e) {
            System.out.println("复制失败: " + e.getMessage());
        }
    }
}