import java.io.*;
import java.util.*;

class Solution
{
    static int solve(int N, int[] Arr, int K){
        // <prefixSum, freq>
        Map<Integer,Integer> map = new HashMap<>();
        int totalSubarrays = 0;
        int prefixSum = 0;
        map.put(0,1);
        for(int i=0;i<Arr.length;i++) {
            prefixSum += Arr[i];

            if(map.containsKey(prefixSum-K)) {
                totalSubarrays += map.get(prefixSum-K);
            }

            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return totalSubarrays;
    }
}
public class SubarraySumEqualsK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_Arr = br.readLine().split(" ");
        int[] Arr = new int[N];
        for(int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++)
        {
            Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
        }
        int K = Integer.parseInt(br.readLine().trim());

        int out_ =  Solution.solve(N, Arr, K);
        System.out.println(out_);

        wr.close();
        br.close();
    }
}