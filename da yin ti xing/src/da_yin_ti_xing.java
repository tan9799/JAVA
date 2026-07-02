public class da_yin_ti_xing {
    public static void main(String[] args) {
        for(int k = 1; k <= 3; k++) {
            for(int i = 0; i < 3 - k; i++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= (2 * k + 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
