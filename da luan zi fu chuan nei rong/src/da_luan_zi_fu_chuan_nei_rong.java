import java.util.Random;
public class da_luan_zi_fu_chuan_nei_rong {
    public static void main(String[] args) {
        //定义一个字符串
        String str = "abcde";
        //把字符串str变成字符数组
        char[] arr = str.toCharArray();
        //打乱字符数组arr中的内容
        Random r = new Random();
        for(int i = 0; i < arr.length; i++) {
            //获取一个随机的索引
            int index = r.nextInt(arr.length);
            //依次得到数组中的每一个字，跟随机索引上的字符进行位置交换
            char temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        String result = new String(arr);
        System.out.println(result);
    }
}
