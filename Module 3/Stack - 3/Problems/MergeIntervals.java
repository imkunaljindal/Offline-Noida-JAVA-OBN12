//import java.util.*;
//import java.lang.*;
//import java.io.*;
//
//class Solution {
//    public void merge(int[][] intervals) {
//
//        // sorting based on starting of the intervals
//        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
//
//        int s1 = intervals[0][0];
//        int e1 = intervals[0][1];
//
//        for(int i=1;i<intervals.length;i++) {
//            int s2 = intervals[i][0];
//            int e2 = intervals[i][1];
//
//            if(e1 >= s2) {
//                // merge
//                s1 = s1;
//                e1 = Math.max(e1,e2);
//            }
//            else {
//                System.out.println(s1 + " " + e1);
//                s1 = s2;
//                e1 = e2;
//            }
//        }
//        System.out.println(s1 + " " + e1);
//    }
//}
//
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int m;
//        m = sc.nextInt();
//        int[][] A = new int[m][2];
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < 2; j++) {
//                A[i][j] = sc.nextInt();
//            }
//        }
//        Solution Obj = new Solution();
//        Obj.merge(A);
//
//    }
//}