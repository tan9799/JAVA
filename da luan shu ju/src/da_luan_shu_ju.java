import java.util.Random;
public class da_luan_shu_ju {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Random r = new Random();
        for(int i = 0; i < arr.length; i++) {
            int randomIndex = r.nextInt(arr.length);
            int tmpt = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = tmpt;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
