public class zhong_wei_shu {
    public static void main(String args[]) {
        int arr1[] = {1, 2, 4, 5, 7, 8, 9};
        int arr2[] = {3, 6, 11, 12};
        int arr3[] = new int[arr1.length + arr2.length];
        int n = 0;
        for(int i = 0; i < arr1.length; i++) {
            arr3[n] = arr1[i];
            n++;
        }
        for(int i = 0; i < arr2.length; i++) {
            arr3[n] = arr2[i];
            n++;
        }
        for(int i = 0; i < arr3.length; i++) {
            for(int j = 0; j < arr3.length - i - 1; j++) {
                if(arr3[j] > arr3[j + 1]) {
                    int tempt = arr3[j];
                    arr3[j] = arr3[j + 1];
                    arr3[j + 1] = tempt;
                }
            }
        }
        if(arr3.length % 2 != 0) {
            System.out.println(arr3[arr3.length / 2]);
        } else {
            System.out.println((arr3[arr3.length / 2] + arr3[arr3.length / 2 - 1]) / 2);
        }
    }
}
