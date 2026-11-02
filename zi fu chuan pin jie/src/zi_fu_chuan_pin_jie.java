public class zi_fu_chuan_pin_jie {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1) {
                sb.append(arr[i]);
                sb.append(']');
            } else {
                sb.append(arr[i]);
                sb.append(", ");
            }
        }
        String atr = sb.toString();
        System.out.println(atr);
    }
}
