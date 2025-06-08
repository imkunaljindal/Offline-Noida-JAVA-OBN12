import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Concept {

    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(10);
        s.add(5);
        s.add(6);
        s.add(1);
        s.add(10);

        System.out.println(s);
    }
}
