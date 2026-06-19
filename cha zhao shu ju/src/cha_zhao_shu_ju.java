import java.util.Scanner;
public class cha_zhao_shu_ju {
    public static void main(String args[]) {
        int arr[] = {33, 5, 22, 44, 55, 33};
        int count = 0;
        int flag = 1;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < arr.length; i++) {
            if(num == arr[i]) {
                count = i;
                flag = 0;
                break;
            }
        }
        if(flag == 0) {
            System.out.println("The number " + num + " is in the array at index " + count);
        } else {
            System.out.println("该数据不存在");
        }
    }
}
