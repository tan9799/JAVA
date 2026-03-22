import java.util.Scanner;
public class zuo_pin_ping_fen {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        double[] scores = new double[number];
        double sum = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for(int i = 0; i < number; i++){
            scores[i] = sc.nextDouble();
            sum += scores[i];
            if(scores[i] > max){
                max = scores[i];
            }
            if(scores[i] < min){
                min = scores[i];
            }
        }
        sum = sum - max - min;
        double avg = sum / (number - 2);
        System.out.printf("%.2f", avg);
    }
}
