import java.util.*;
class Main{
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int t=sc.nextInt();
            while(t>0){
                int n=sc.nextInt();
                int []A=new int[n];
                int m=sc.nextInt();
                int k=sc.nextInt();
                for(int i=0;i<n;i++){
                    A[i]=sc.nextInt();
                }
                Solution ob =new Solution();
                int ans = ob.minDays(A,n,m,k);
                System.out.println(ans);
                t--;
            }
        }
    }

}
class Solution {
    public int minDays(int[] bloomDay,int n, int m, int k) {
        if(m*k>n)
        {
            return -1;
        }
        int left=Integer.MAX_VALUE;
        int right=Integer.MIN_VALUE;
        int result=-1;
        for(int bloom:bloomDay)
        {
            right=Math.max(right,bloom);
            left=Math.min(left,bloom);
        }
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(isPossible(mid, bloomDay, m, k))
            {
                result=mid;
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return result;
    }
    public boolean isPossible(int mid, int[]bloomDay, int m, int k)
    {
        int c=0;
        int total=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i]<=mid)
            {
                c++;
                if(c==k)
                {
                    total++;
                    c=0;
                }
            }
            else
            {
                c=0;
            }
        }
        return total>=m;
    }
}