import java.util.Random;
public class qu_chu_chong_fu_shu_ju_plus {
    public static void main(String args[]) {
        Random r = new Random();
        int flag = 1;
        int arr[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        for(int i = 0; i < arr.length;) {
            int a = r.nextInt(0,101);
            for(int j = 0; j < i; j++) {
                if(arr[j] == a) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1) {
                arr[i] = a;
                i++;
                flag = 0;
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
