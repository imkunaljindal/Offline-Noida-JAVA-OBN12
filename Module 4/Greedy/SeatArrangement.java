import java.util.*;

class Solution {

    public int seat(String s) {
        int n = s.length();
        ArrayList<Integer> pos = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(s.charAt(i)=='x') pos.add(i);
        }

        int sz = pos.size();
        int medianPos = pos.get(sz/2);

        int totalEffort = 0;
        int nextAvailPos = medianPos-1;
        for(int i=sz/2-1; i>=0; i--) {
            totalEffort += (nextAvailPos-pos.get(i));
            nextAvailPos--;
        }

        nextAvailPos = medianPos+1;
        for(int i=sz/2+1; i<sz;i++) {
            totalEffort += (pos.get(i)-nextAvailPos);
            nextAvailPos++;
        }

        return totalEffort;
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.seat(str));
    }
}
