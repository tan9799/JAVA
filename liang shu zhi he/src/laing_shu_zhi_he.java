import java.util.Scanner;
public class laing_shu_zhi_he {
    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 4, 5};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == n) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}
