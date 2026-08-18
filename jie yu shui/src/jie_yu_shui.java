public class jie_yu_shui {
    public static void main(String args[]) {
        //定义数组
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //从左往右遍历，记录雨水+柱子的面积总和
        //定义数组记录从左往右看的数据
        int leftMax[] = new int[arr.length];
        //定义第三方变量temp，记录当前最高的柱子
        int temp = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(temp > arr[i]) {
                leftMax[i] = temp;
            } else {
                leftMax[i] = arr[i];
                temp = arr[i];
            }
        }
        //从右往左遍历，记录雨水+柱子的面积总和
        int rightMax[] = new int[arr.length];
        temp = arr[arr.length - 1];
        for(int i = arr.length - 1;i >= 0; i--) {
            if(temp > arr[i]) {
                rightMax[i] = temp;
            } else {
                rightMax[i] = arr[i];
                temp = arr[i];
            }
        }
        //取交集 求和
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(leftMax[i] < rightMax[i]) {
                result[i] = leftMax[i] - arr[i];
            } else {
                result[i] = rightMax[i] - arr[i];
            }
        }
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
