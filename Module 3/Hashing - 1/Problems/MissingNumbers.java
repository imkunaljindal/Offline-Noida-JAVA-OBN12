import java.util.*;

class Solution {
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        Map<Integer,Integer> freq1 = new HashMap<>();
        Map<Integer,Integer> freq2 = new HashMap<>();

        for(int i=0;i<n;i++) {
            freq1.put(arr[i],freq1.getOrDefault(arr[i],0)+1);
        }

        for(int i=0;i<m;i++) {
            freq2.put(brr[i],freq2.getOrDefault(brr[i],0)+1);
        }

        List<Integer> ans = new ArrayList<>();
        for(int key: freq2.keySet()) {
            if(!freq1.containsKey(key)) ans.add(key);
            else if(freq1.get(key)!=freq2.get(key)) ans.add(key);
        }

        Collections.sort(ans);
        for(int i=0;i<ans.size();i++) {
            System.out.print(ans.get(i) + " ");
        }

        if(ans.size()==0) System.out.println(-1);
    }

}

public class MissingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0; i<m; i++){
            brr[i]= sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n,arr,m,brr);
    }
}