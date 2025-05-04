import java.util.ArrayList;

public class Concept {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(10);
        arr.add(20);
        arr.add(30);

        System.out.println(arr);
        arr.add(2,40);
        System.out.println(arr);
        arr.set(2,60);
        System.out.println(arr);
    }
}
