import java.util.Scanner;
public class ping_wei_da_fen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];
        for(int i = 0; i < arr.length;) {
            System.out.println("请输入评分：");
            int a = sc.nextInt();
            if(a >= 0 && a <= 100) {
                arr[i] = a;
                i++;
            } else {
                System.out.println("请重新输入分数：");
            }
        }
        int sum = 0;
        for(int j = 0; j < arr.length; j++) {
            sum += arr[j];
        }
        int max = getMax(arr);
        int min = getMin(arr);
        double avg = (sum - max - min) / 3.0;
        System.out.println("平均分：" + avg);
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
    public static int getMin(int arr[]) {
        int min = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
