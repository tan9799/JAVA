public class zhuanyekeTeacher extends Teacher{
    String subject;
    public zhuanyekeTeacher(){
    }
    public zhuanyekeTeacher(String name, int age, String subject) {
        super(name, age, subject);
        this.subject = subject;
    }
    public void teach(){
        System.out.println("老师" + getName() + "正在讲" + subject);
    }
}
