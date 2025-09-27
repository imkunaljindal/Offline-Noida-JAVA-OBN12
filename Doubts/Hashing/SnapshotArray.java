import java.util.*;

public class SnapshotArray
{
    static TreeMap<Integer, Integer>[] A;
    static int snap_id = 0;
    public static void SnapshotArray(int length) {
        A = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            A[i] = new TreeMap<Integer, Integer>();
            A[i].put(0, 0);
        }
    }

    public static void set(int index, int val) {
        A[index].put(snap_id, val);
    }

    public static int snap() {
        return snap_id++;
    }

    public static int get(int index, int snap_id) {
        return A[index].floorEntry(snap_id).getValue();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String temp;
        int param1, param2;
        param1 = input.nextInt();
        SnapshotArray(param1);
        String[] arr = new String[n];
        for (int i = 0; i < n; i++){

            temp = input.next();
            if(temp.equals("set") || temp.equals("get"))
            {
                param1 = input.nextInt();
                param2 = input.nextInt();
                if(temp.equals("set"))
                {
                    set(param1, param2);
                }
                else{
                    System.out.println(get(param1, param2));
                }
            }
            else{
                System.out.println(snap());
            }
        }

    }
}