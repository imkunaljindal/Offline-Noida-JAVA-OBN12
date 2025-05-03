package Problems;

import java.io.*;
import java.util.*;

public class TripletSumToX {
    public static int triplets(ArrayList<Integer> arr, int X) {
        int count = 0;
        int n = arr.size();
        for(int i=0;i<n;i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((arr.get(i) + arr.get(j) + arr.get(k) == X)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t > 0) {
            int n, X;
            n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++) arr.add(sc.nextInt());
            X = sc.nextInt();
            int result = triplets(arr, X);
            System.out.println(result);
            t--;
        }
        sc.close();
    }


}