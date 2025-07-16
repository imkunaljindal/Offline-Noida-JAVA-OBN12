import java.util.*;

class Solution {
    static boolean arr[] = new boolean[1000001];
    public void add(int key) {
        if(arr[key]!=true) arr[key] = true;
    }

    public void remove(int key) {
        if(arr[key]==true) arr[key] = false;
    }

    public boolean contains(int key) {
        return arr[key];
    }
}

public class DesignHashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution Obj = new Solution();
        for (int i = 0; i < q; i++) {
            int choice = sc.nextInt();
            int key = sc.nextInt();
            if (choice == 1) {
                // Add
                Obj.add(key);
            } else if (choice == 2) {
                // contains
                if (Obj.contains(key)) {
                    System.out.print("True ");
                } else {
                    System.out.print("False ");
                }
            } else if (choice == 3) {
                // remove
                Obj.remove(key);
            }
        }
        System.out.println();
        sc.close();
    }
}