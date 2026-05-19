import java.util.*;
public class test {
    public int hashCode() {
        return 1;
    }
    public boolean equals(Object b) {
        return true;
    }
    public static void main(String args[]) {
        Set set = new HashSet();
        set.add(new test());
        set.add(new String("ABC"));
        set.add(new test());
        System.out.println(set.size());
    }
}
