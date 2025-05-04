import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InbuiltSort {

    public static void main(String[] args) {
        int arr[] = {4,1,5,2};

        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }

        ArrayList<String> a = new ArrayList<>();
        a.add("virat");
        a.add("rohit");
        a.add("rabada");

        Collections.sort(a);
        System.out.println(a);
    }
}
