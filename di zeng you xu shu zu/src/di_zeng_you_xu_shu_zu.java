import java.util.Random;
public class di_zeng_you_xu_shu_zu {
    public static void main(String args[]) {
        Random r = new Random();
        int flag = 1;
        int arr[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        for(int i = 0; i < arr.length;) {
            int a = r.nextInt(0,101);
            flag = 1;
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
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i -1; j++){
                if(arr[j] > arr[j + 1]) {
                    int tempt = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempt;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

