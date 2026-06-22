import java.util.Random;
import java.util.Scanner;

public class da_le_tou {
    public static void main(String[] args) {
        //1.利用Random随机生成彩票号码
        int [] lotteryNumber =createLotteryNumber();
        printLotteryNumber(lotteryNumber);
        //2.利用Scanner模拟购买彩票
        int [] myLotteryNumber =buyLotteryNumber();
        printLotteryNumber(myLotteryNumber);
        //3.判断中奖
        //判断中了几个前区
        //判断中了几个后区
        getWinnerNumber(lotteryNumber, myLotteryNumber);
    }
    //作用：判断arr2里面的数据，在arr1中出现了几次
    //arr1:真正的彩票号码
    //arr2:用户购买的彩票号码
    public static void getWinnerNumber(int [] arr1, int [] arr2){
        int count1 = getCount(arr1, arr2, 0, 4);
        System.out.println("前区中奖个数：" + count1);
        //判断后区中了几个号码
        int count2 = getCount(arr1, arr2, 5, 6);
        System.out.println("前区中奖个数：" + count2);
    }

    public static int getCount(int[] arr1, int[] arr2, int start, int end) {
        int count = 0;
        for(int i = start; i <= end; i++) {
            boolean flag = contains(arr2[i], arr1, start, end);
            if(flag) {
                count++;
            }
        }
        return count;
    }


    public static int[] buyLotteryNumber() {
        //1.创建一个数组
        int[] arr = new int[7];
        //2.利用Scanner模拟购买彩票，1~35选5个号码（唯一）
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5;) {
            System.out.println("请输入第" + (i + 1) + "个彩票号码：");
            int number = sc.nextInt();
            //范围
            if(number < 1 || number > 35) {
                System.out.println("当前彩票号码不在规定范围中，请重新选择");
                continue;
            }
            //唯一
            boolean flag = contains(number, arr, 0, 4);
            if(flag) {
                System.out.println("当前彩票号码已存在，请重新选择");
                continue;
            }
            //添加
            arr[i] = number;
            i++;
        }
        for (int i = 0; i < 2;) {
            System.out.println("请输入第" + (i + 1) + "个彩票号码：");
            int number = sc.nextInt();
            //范围
            if(number < 1 || number > 12) {
                System.out.println("当前彩票号码不在规定范围中，请重新选择");
                continue;
            }
            //唯一
            boolean flag = contains(number, arr, 5, 6);
            if(flag) {
                System.out.println("当前彩票号码已存在，请重新选择");
                continue;
            }
            //添加
            arr[i + 5] = number;
            i++;
        }
        return arr;
    }
    public static int[] createLotteryNumber() {
        //1.创建数组
        int[] arr = new int[7];
        //2.利用Random生成彩票号码，先生成前区的五个号码，1~35选5个号码（唯一）
        Random r = new Random();
        for(int i = 0; i < 5; ) {
            int number = r.nextInt(35) + 1;
            //在前面的五个数据中，判断number是否唯一
            boolean flag = contains(number, arr, 0, 4);
            if (!flag) {
                arr[i] = number;
                i++;
            }
        }
        //3.利用Random生成彩票号码，先生成后两个号码，1~12选2个号码（唯一）
        for (int i = 0; i < 2; ) {
            int number = r.nextInt(1, 13);
            //在后面的两个数据中，判断number是否唯一
            boolean flag = contains(number, arr, 5, 6);
            if (!flag) {
                arr[i + 5] = number;
                i++;
            }
        }
        return arr;
    }
    public static boolean contains(int number, int[] arr, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(arr[i] == number) {
                return true;
            }
        }
        return false;
    }
    public static void printLotteryNumber(int[] arr) {
        System.out.print("(");
        for(int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print(")");
    }
}
