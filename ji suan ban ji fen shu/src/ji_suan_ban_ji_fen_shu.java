import java.util.Scanner;
public class ji_suan_ban_ji_fen_shu {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        for(int i = 0; i < arr.length;) {
            int a = sc.nextInt();
            if(a >= 0 && a <= 100) {
                arr[i] = a;
                i++;
            } else {
                System.out.println("成绩无效，请重新输入");
            }
        }
        System.out.println("及格人数：" + jigerenshu(arr) + "及格率：" + jigerenshu(arr) / (double)arr.length);
        System.out.println("平均分是：" + sum(arr) / (double)arr.length);
        System.out.println("最高分是：" + getMax(arr));
    }
    public static int jigerenshu(int arr[]) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 60) {
                count++;
            }
        }
        return count;
    }
    public static int sum (int arr[]) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static int getMax(int arr[]) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
