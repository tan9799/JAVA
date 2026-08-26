import java.util.Random;
public class pan_duan_shu_zi_zai_shu_zu_zhong_shi_fou_cun_zai {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for(int i = 0; i < arr.length;) {
            int num = r.nextInt(100) + 1;
            boolean flag = contains(num, arr);
            if(!flag) {
                arr[i] = num;
                i++;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static boolean contains(int num, int[] arr) {
        for(int i = 0 ; i < arr.length; i++) {
            if(arr[i] == num) {
                return true;
            }
        }
        return false;
    }
}
