public class he_bing_you_xu_shu_zu {
    public static void main(String args[]) {
        int arr1[] = {1, 3, 5, 7, 9};
        int arr2[] = {2, 4, 6, 8, 10};
        int arr[] = new int[10];
        for(int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }
        for(int i = arr1.length; i < arr1.length + arr2.length; i++) {
            arr[i] = arr2[i - arr1.length];
        }
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
