public class fu_li_ji_suan_qi {
    public static void main(String[] args) {
        int benjin = 10000;
        double sum = benjin;
        int count= 0;
        while(sum <= 20000) {
            sum = sum * 1.017;
            count++;
        }
        System.out.println(count);
    }
}
