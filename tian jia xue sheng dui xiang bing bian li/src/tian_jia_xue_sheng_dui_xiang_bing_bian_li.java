import java.util.ArrayList;

public class tian_jia_xue_sheng_dui_xiang_bing_bian_li {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        Student s1 = new Student(101, "q", 12);
        Student s2 = new Student(102, "w", 13);
        Student s3 = new Student(103, "e", 14);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        for(int i = 0; i < list.size(); i++){
            Student s = list.get(i);
            System.out.println(s.getId() + " " + s.getName() + " " + s.getAge());
        }
        System.out.println(find(list, 102));
    }
    public static int find(ArrayList<Student> list, int id) {
        for(int i = 0; i < list.size(); i++) {
            Student s = (Student) list.get(i);
            if (s.getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
