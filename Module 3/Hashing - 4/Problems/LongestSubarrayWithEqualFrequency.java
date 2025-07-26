import java.util.*;

class Solution{
    public static int longestSubarray(int[] arr){
        Map<String,Integer> map = new HashMap<>();
        int zeroes = 0;
        int ones = 0;
        int twos = 0;

        map.put("0#0",-1);
        int ans = -1;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==0) zeroes++;
            else if(arr[i]==1) ones++;
            else twos++;

            String key = (ones-zeroes) + "#" + (twos-ones);
            if(map.containsKey(key)) {
                ans = Math.max(ans,i-map.get(key));
            }
            else map.put(key,i);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubarray(arr));
    }
}
