import java.util.*;

public class Main { public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int q = sc.nextInt();
    int [] arr= new int[n];
    for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
    }

    int [][] queries= new int[q][2];

    for(int i=0;i<q;i++){
        for(int j=0;j<2;j++){
            queries[i][j]=sc.nextInt();
        }
    }

    Solution Obj= new Solution();
    int [] result = Obj.xorQueries(arr,queries);
    for(int i=0;i<result.length;i++){
        System.out.print(result[i]+" ");
    }
}
}

class Solution{

    public int[] xorQueries(int[] arr, int[][] q) {
        int n = arr.length;
        int prefixXor[] = new int[n];

        for(int i=0;i<n;i++) {
            if(i==0) prefixXor[i] = arr[i];
            else prefixXor[i] = prefixXor[i-1]^arr[i];
        }

        int ans[] = new int[q.length];

        for(int i=0;i<q.length;i++) {
            int l = q[i][0];
            int r = q[i][1];

            if(l==0) ans[i] = prefixXor[r];
            else ans[i] = prefixXor[r]^prefixXor[l-1];
        }

        return ans;
    }
}