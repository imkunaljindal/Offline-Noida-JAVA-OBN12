//
//import java.util.*;
//import java.lang.*;
//import java.io.*;
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] trips = new int[n][3];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 3; j++) {
//                trips[i][j] = sc.nextInt();
//            }
//        }
//        int k = sc.nextInt();
//
//        Solution obj= new Solution();
//        System.out.println(obj.carPooling(trips,k));
//    }
//}
//class Solution{
//
//    public boolean carPooling(int[][] trips, int capacity) {
//
//        int passInCar[] = new int[1001];
//        int n = trips.length;
//
//        for(int i=0;i<n;i++) {
//            int numOfPass = trips[i][0];
//            int from = trips[i][1];
//            int to = trips[i][2];
//
//            passInCar[from] += numOfPass;
//            passInCar[to] -= numOfPass;
//        }
//
//        // complete prefix arrays
//        for(int i=0;i<=1000;i++) {
//            if(i>0) {
//               passInCar[i] = passInCar[i-1] + passInCar[i];
//            }
//            if(passInCar[i] > capacity) return false;
//        }
//
//        return true;
//    }
//}