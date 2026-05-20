import java.util.ArrayList;
import java.util.List;
public class Test {
    public static void main(String args[]) {
        List list = new ArrayList();
        list.add(new Test());
        list.add(new String("ABC"));
        list.add(new Test());
        System.out.println(list.size());
    }
}