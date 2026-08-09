public class feng_7_guo {
    public static void main(String args[]) {
        for(int i = 1; i <= 100; i++) {
            int gewei = i % 10;
            int shiwei = i / 10;
            if(i % 7== 0 || gewei == 7 || shiwei == 7) {
                System.out.println("skip");
                continue;
            }
            System.out.println(i);
        }
    }

}
