public class testThread {
    public static void main(String args[]){
        Thread t = Thread.currentThread();
        t.setName("单线程"); //对线程取名为“单线程 "
        t.setPriority(8); //设置线程优先级为8，最高为10，最低为1，默认为5
        System.out.println("The running thread: " + t);
        try{
            for(int i=0;i<3;i++){
                System.out.println("Sleep time " + i);
                Thread.sleep(100);  } // 睡眠100毫秒
        }catch(InterruptedException e){// 捕获异常
            System.out.println("thread has wrong");     }
    }
}
