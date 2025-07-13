import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConceptOfHashSet {

    public static void main(String[] args) {
//        Set<Integer> s = new HashSet<>();
//
//        s.add(10);
//        s.add(20);
//        s.add(30);
//        s.add(10);
//
//        System.out.println(s);
//        System.out.println(s.size());
//        s.remove(10);
//        System.out.println(s);

        Map<String,Integer> map = new HashMap<>();
        map.put("Rohit",40);
        map.put("Kohli",30);
        map.put("Pant",60);

       // System.out.println(map);

        for(String name: map.keySet()) {
            System.out.println(name);
        }

        for(int score: map.values()) {
            System.out.println(score);
        }

        System.out.println("Kohli = "+ map.get("kohli"));

        map.put("Kohli",50);
        System.out.println(map.get("Kohli"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.remove("Kohli");
        System.out.println(map.size());

        System.out.println(map.containsKey("Bumrah"));
    }
}
