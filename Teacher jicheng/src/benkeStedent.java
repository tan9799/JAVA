public class benkeStedent extends Student{
    public benkeStedent(){
    }
    public benkeStedent(String name, int age, String grade){
        super(name, age, grade);
    }
    public void study(){
        System.out.println("攻读学士学位");
    }
}
