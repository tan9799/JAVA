import java.util.Random;
public class tong_ji_ge_shu {
    public static void main(String args[]) {
        Random r = new Random();
        int candidate[] = new int[6];
        for(int i = 0; i < 1000; i++) {
            int num = r.nextInt(6);
            if(num == 1) {
                candidate[0]++;
            } else if(num == 2) {
                candidate[1]++;
            } else if(num == 3) {
                candidate[2]++;
            } else if(num == 4) {
                candidate[3]++;
            } else if(num == 5){
                candidate[4]++;
            } else if(num == 0) {
                candidate[5]++;
            }
        }
        int num = 0;
        int max = candidate[0];
        for(int i = 0; i < 5; i++) {
            if(candidate[i] > max) {
                max = candidate[i];
                num = i;
            }
        }
        for(int i = 0; i < candidate.length; i++) {
            System.out.println("第" + (i + 1) + "个候选者有" + candidate[i] + "票" + "，得票率是：" + (candidate[i] / 1000.0));
        }
        System.out.println("得票数最多的候选人是" + num + "，得票数是" + max);
        System.out.println("没有投票的人有" + candidate[5] + "人" + "弃票率是" + candidate[5] / 1000.0);
    }
}
