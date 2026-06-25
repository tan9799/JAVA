public class da_yin_kong_xin_ling_xing {
    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2 - i; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int k = 0; k < 2 * i - 1; k++){
                System.out.print(" ");
            }
            if(i != 0) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 1; i < 3; i++){
            for(int j = 0; j < i; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            if(i != 2) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
