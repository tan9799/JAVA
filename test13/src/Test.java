public class Test {
    public static void main(String[] args) {
        try {
            System.out.println(1 / 1);//0不能做除数
        } catch(Exception e) {
            e.printStackTrace();//打印错误信息
            //System.out.println("系统出错了，请联系管理员");//给客户看的
        }finally{ //一般做收尾工作
            System.out.println("你好啊，我是finally");
        }

        //1.异常是错误，运行时异常
        //2.抛异常，创建一个错误对象，把错误对象丢出来
        //3.捕获异常，默认由JVM来把错误信息进行捕获，打印出来,JVM会终止程序的执行
    }
}
