import java.util.Arrays;
import java.util.Collections;

public class Concept {

    public static void main(String[] args) {
        Integer arr[] = {4,3,2,5,6,0};

        String[] arr2 = {"abc","gf","adfg","d","xyzg"};

//        Arrays.sort(arr, (a,b) -> b-a);
//        for(int i=0;i<arr.length;i++) {
//            System.out.print(arr[i] + " ");
//        }

//        Arrays.sort(arr2, (a,b) -> b.length()-a.length());
//        for(int i=0;i<arr2.length;i++) {
//            System.out.print(arr2[i] + " ");
//        }

        int[][] arr3 = {{8,11,7}, {3,1,20}, {5,7,9}};
        Arrays.sort(arr3, (a,b) -> b[2]-a[2]);

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
