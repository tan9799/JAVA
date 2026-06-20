import java.util.Scanner;
public class cha_zhao_yuan_su {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int arr[] = {1, 3, 5, 6};
        int flag = 1;
        int arrFinal[] = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                System.out.println(i);
                flag = 0;
                break;
            }
        }
        if(flag == 1) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] > target) {
                    System.out.println(i);
                    flag = 0;
                    break;
                }
            }
            if(flag == 1) {
                System.out.println(arr.length);
            }
        }
    }
}
