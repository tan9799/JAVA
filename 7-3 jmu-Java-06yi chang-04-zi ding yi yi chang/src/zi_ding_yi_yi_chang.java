import java.util.Scanner;

class IllegalScoreException extends Exception {
    public IllegalScoreException(String message) {
        super(message);
    }
}

class IllegalNameException extends RuntimeException {
    public IllegalNameException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private int score;

    public Student() {}

    public String getName() { return name; }
    public void setName(String name) throws IllegalNameException {
        if (name != null && name.length() > 0 && Character.isDigit(name.charAt(0))) {
            throw new IllegalNameException("the first char of name must not be digit, name=" + name);
        }
        this.name = name;
    }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public int addScore(int score) throws IllegalScoreException {
        int newScore = this.score + score;
        if (newScore < 0 || newScore > 100) {
            throw new IllegalScoreException("score out of range, score=" + newScore);
        }
        this.score = newScore;
        return this.score;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", score=" + score + "]";
    }
}

public class zi_ding_yi_yi_chang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            while (in.hasNextLine()) {
                String cmd = in.nextLine().trim();
                if (cmd.equals("new")) {
                    if (!in.hasNextLine()) break;
                    String dataLine = in.nextLine();
                    Student s = new Student();
                    try (Scanner lineScanner = new Scanner(dataLine)) {
                        String name = lineScanner.next();
                        int score = lineScanner.nextInt();
                        s.setName(name);
                        s.addScore(score); // 注意：addScore是加分数，但初始score为0，所以新分数就是score
                        // 这里实际上addScore传入的是要加的分数，但我们希望设置初始分数，所以可以直接setScore？但题目要求使用addScore方法，并且如果分数不在0-100内抛出异常。所以我们可以先setScore(0)再addScore(score)？更好：在构造时score默认为0，然后调用addScore(score)即可。
                        // 注意：addScore抛出异常时，不改变score。
                        System.out.println(s);
                    } catch (IllegalNameException | IllegalScoreException e) {
                        System.out.println(e);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    break;
                }
            }
        } finally {
            in.close();
            System.out.println("scanner closed");
        }
    }
}
