import java.util.Random;
public class qu_chu_chong_fu_yuan_su {
    public static void main(String args[]) {
        Random r = new Random();
        int arr[] = new int[10];
        int flag = 1;
        for(int i = 0; i < arr.length;) {
            int a = r.nextInt(1,101);
            for(int j = 0; j < i; j++) {
                if(arr[j] == a) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1) {
                arr[i] = a;
                i++;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
