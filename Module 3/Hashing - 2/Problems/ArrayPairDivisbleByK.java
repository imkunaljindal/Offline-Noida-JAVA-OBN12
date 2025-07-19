import java.io.*;
import java.util.*;

class Solution {
    public boolean arrayPairs(int[] arr, int k) {
        //<mod,freq>
        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            int key = arr[i]%k;
            freqMap.put(key,freqMap.getOrDefault(key,0)+1);
        }

        for(int key: freqMap.keySet()) {
            if(key==0) {
                if(freqMap.get(key)%2!=0) return false;
            }
            else {
                int complimentary = k-key;
                if(freqMap.get(key)!=freqMap.get(complimentary)) return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        if(Obj.arrayPairs(arr,k)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}