import java.util.Scanner;

import java.util.*;

class Solution {

    public static boolean isPossible(int []piles, int H, int speed) {
        int hrs = 0;
        for(int i=0;i<piles.length;i++) {
            hrs += (int)Math.ceil(piles[i]/speed*1.0);
        }

        return hrs<=H;
    }
    
    public static int minEatingSpeed(int[] piles, int H) {
        int maxSize = 0;
        for(int pile: piles) {
            maxSize = Math.max(maxSize,pile);
        }
        int s = 0;
        int e = maxSize;
        int ans = -1;
        while(s<=e) {
            int mid = s + (e-s)/2;
            if(isPossible(piles,H,mid)) {
                ans = mid;
                e = mid-1;
            }
            else s = mid+1;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int h = scanner.nextInt();
        System.out.println(Solution.minEatingSpeed(array, h));
        scanner.close();
    }
}
