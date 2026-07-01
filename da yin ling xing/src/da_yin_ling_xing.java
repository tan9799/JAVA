public class da_yin_ling_xing {
    public static void main(String[] args) {
        for(int k = 1; k < 5; k++) {
            for(int i = 0; i < 4 - k; i++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= (2 * k - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int k = 1; k < 4; k++) {
            for(int i = 0; i < k; i++) {
                System.out.print(" ");
            }
            for(int j = 0; j < (7 - 2 * k); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
