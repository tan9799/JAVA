import java.io.*;
import java.util.Scanner;
public class he_bing_wen_jian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个文件名: ");
        String file1 = scanner.nextLine();
        System.out.print("请输入第二个文件名: ");
        String file2 = scanner.nextLine();
        System.out.print("请输入合并后的文件名: ");
        String target = scanner.nextLine();
        try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
             BufferedReader br2 = new BufferedReader(new FileReader(file2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(target))) {
            String line;
            while ((line = br1.readLine()) != null) {
                bw.write(line);
                bw.newLine();  // 保持原换行
            }
            while ((line = br2.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("文件合并成功！生成文件: " + target);
        } catch (FileNotFoundException e) {
            System.err.println("文件未找到: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("读写错误: " + e.getMessage());
        }
        scanner.close();
    }
}