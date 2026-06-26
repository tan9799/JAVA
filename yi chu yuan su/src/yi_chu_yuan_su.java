import java.util.Scanner;
public class yi_chu_yuan_su {
    public static void main(String args[]) {
        int arr[] = {1, 2, 2, 4, 5};
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != val) {
                arr[j] = arr[i];
                j++;
            }
        }
        for(int i = 0; i < j; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
