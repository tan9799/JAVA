public class kuai_man_zhi_zhen {
    public static void main(String args[]) {
        int arr[] = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        //定义两个指针
        int slow = 0;
        int fast = 1;
        //利用循环不断的移动快慢指针，找不重复的元素
        while (fast < arr.length) {
            //判断两个指针指向的的数据是否相同
            if(arr[slow] == arr[fast]) {
                //相等
                fast++;
            } else {
                slow++;
                arr[slow] = arr[fast];
                fast++;
            }
        }
        for(int i = 0; i <= slow; i++) {
            System.out.println(arr[i]);
        }
    }
}
