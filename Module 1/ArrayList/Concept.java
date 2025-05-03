import java.util.ArrayList;

public class Concept {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(10);
        arr.add(20);

        arr.add(30);

      //  System.out.println(arr.get(2));

        arr.add(2,40);

       // System.out.println(arr.get(2));

        arr.remove(2);

        System.out.println(arr);
    }
}
