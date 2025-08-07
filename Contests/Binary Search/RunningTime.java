import java.io.*;
import java.util.*;


public class RunningTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution s = new Solution();
        System.out.println(s.countNumberOfInsertionSortInversions(arr));
    }
}

class Solution {
    static int countNumberOfInsertionSortInversions(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
                count++;
            }
        }
        return count;
    }
}