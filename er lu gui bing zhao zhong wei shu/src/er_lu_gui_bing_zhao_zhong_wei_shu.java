public class er_lu_gui_bing_zhao_zhong_wei_shu {
    public static void main(String args[]) {
        int arr1[] = {1, 3, 5, 7, 9};
        int arr2[] = {2, 4};
        int arr[] = new int[arr1.length + arr2.length];
        int n = 0;
        //在添加的过程中，保证顺序
        //前提：arr1，arr2必须是正序
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < arr.length; i++) {
            if(index1 == arr1.length) {
                arr[i] = arr2[index2];
                index2++;
                continue;
            }
            if(index2 == arr2.length) {
                arr[i] = arr1[index1];
                index1++;
                continue;
            }
            if(arr1[index1] > arr2[index2]) {
                arr[i] = arr2[index2];
                index2++;
            } else {
                arr[i] = arr1[index1];
                index1++;
            }
        }
        if(arr.length % 2 == 0) {
            System.out.println((arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0);
        } else {
            System.out.println(arr[arr.length / 2]);
        }
    }
}
