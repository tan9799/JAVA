public class zhe_die_zhi_zhang {
    public static void main(String[] args) {
        double zhihou = 0.1;
        int count = 0;
        while(zhihou < 8848860) {
            zhihou *= 2;
            count++;
        }
        System.out.println(count);
    }
}
