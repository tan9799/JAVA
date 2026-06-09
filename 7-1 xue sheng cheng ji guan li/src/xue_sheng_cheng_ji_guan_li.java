import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        // 按成绩从高到低排序，成绩相同按学号从小到大
        if (this.score != o.score) {
            return Integer.compare(o.score, this.score);
        } else {
            return Integer.compare(this.id, o.id);
        }
    }

    @Override
    public String toString() {
        return id + " " + name + " " + score;
    }
}

public class xue_sheng_cheng_ji_guan_li {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            switch (command) {
                case "ADD":
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    int score = Integer.parseInt(parts[3]);
                    addStudent(id, name, score);
                    break;
                case "DELETE":
                    int delId = Integer.parseInt(parts[1]);
                    deleteStudent(delId);
                    break;
                case "FIND":
                    int findId = Integer.parseInt(parts[1]);
                    findStudent(findId);
                    break;
                case "UPDATE":
                    int updId = Integer.parseInt(parts[1]);
                    int newScore = Integer.parseInt(parts[2]);
                    updateStudent(updId, newScore);
                    break;
                case "LIST":
                    listStudents();
                    break;
                case "STATS":
                    stats();
                    break;
                default:
                    // 无效命令，忽略
                    break;
            }
        }
        scanner.close();
    }

    private static void addStudent(int id, String name, int score) {
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Duplicate ID");
                return;
            }
        }
        students.add(new Student(id, name, score));
        System.out.println("Added");
    }

    private static void deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                System.out.println("Deleted");
                return;
            }
        }
        System.out.println("Not found");
    }

    private static void findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Not found");
    }

    private static void updateStudent(int id, int newScore) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setScore(newScore);
                System.out.println("Updated");
                return;
            }
        }
        System.out.println("Not found");
    }

    private static void listStudents() {
        if (students.isEmpty()) {
            return;
        }
        // 排序
        Collections.sort(students);
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void stats() {
        if (students.isEmpty()) {
            System.out.println("No students");
            return;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Student s : students) {
            int score = s.getScore();
            sum += score;
            if (score > max) max = score;
            if (score < min) min = score;
        }
        double avg = (double) sum / students.size();
        System.out.printf("Average: %.2f, Max: %d, Min: %d\n", avg, max, min);
    }
}