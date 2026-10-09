public class tongshikeTeacher extends Teacher{
    public tongshikeTeacher(){
    }
    public tongshikeTeacher(String name, int age, String subject) {
        super(name, age, subject);
    }
    public void teach(){
        System.out.println("老师"+getName()+"正在给学生讲授");
    }
}
