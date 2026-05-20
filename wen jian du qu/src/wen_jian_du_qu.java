import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class wen_jian_du_qu {
    public static void main(String[] args) {
        new FileFrame();
    }
}
class FileFrame extends Frame implements ActionListener {
    TextArea ta;
    JButton open, quit;
    FileDialog fd;

    FileFrame() {
        super("获取并显示文本文件");
        ta = new TextArea(10, 45);
        open = new JButton("打开");
        quit = new JButton("关闭");
        open.addActionListener(this);
        quit.addActionListener(this);
        setLayout(new FlowLayout());
        add(ta);
        add(open);
        add(quit);
        setSize(350, 280);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("打开")) {
            fd = new FileDialog(this, "打开文件", FileDialog.LOAD);
            fd.setDirectory(".");  // 设置初始目录
            fd.setVisible(true);
            String fileName = fd.getFile();
            String dirName = fd.getDirectory();
            if (fileName != null && dirName != null) {
                File file = new File(dirName, fileName);
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    ta.setText(content.toString());
                } catch (UnsupportedEncodingException ue) {
                    ta.setText("不支持的编码：" + ue.getMessage());
                } catch (FileNotFoundException fnf) {
                    ta.setText("文件未找到：" + fnf.getMessage());
                } catch (IOException ioe) {
                    ta.setText("读取文件错误：" + ioe.getMessage());
                }
            }
        } else if (e.getActionCommand().equals("关闭")) {
            dispose();
            System.exit(0);
        }
    }
}