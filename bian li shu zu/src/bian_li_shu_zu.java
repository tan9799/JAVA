public class bian_li_shu_zu {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        bianli(arr);
    }
    //定义方法遍历数组
    //没有返回值的，不需要把结果返回给上面的调用处，此时返回值类型用void
    public static void bianli(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            if(i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.println(arr[i] + "]");
            }
        }
    }
}
