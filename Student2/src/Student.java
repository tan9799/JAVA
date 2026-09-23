public class Student {
    private String name;
    private int age;
    static private String teacherName;
    public Student(){
    }
    public Student(String name, int age, String teacherName) {
        this.name = name;
        this.age = age;
        this.teacherName = teacherName;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setteacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public String getteacherName() {
        return teacherName;
    }
}
