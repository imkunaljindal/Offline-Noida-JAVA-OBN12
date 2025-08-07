import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int houses[] = new int[n];
        for(int i=0;i<n;i++) {
            houses[i] = sc.nextInt();
        }
        int ninjas[] = new int[m];
        for(int i=0;i<m;i++) {
            ninjas[i] = sc.nextInt();
        }
        int ans = Solution.findMinimumRadiusRange(houses,ninjas,n,m);
        System.out.println(ans);
    }
}

class Solution
{
    static int findMinimumRadiusRange(int houses[], int ninjas[], int n, int m)
    {
        // Sort the arrays to apply binary search
        Arrays.sort(houses);
        Arrays.sort(ninjas);

        int ans=0;
        for(int house : houses)
        {
            int r = m-1;
            int l=0;
            if(ninjas[l] == house || ninjas[r] == house)continue;
            while(r>l+1)
            {
                int mid = ( l + r ) / 2;
                if(ninjas[mid] > house)
                    r = mid;
                else
                    l = mid;
            }

            ans = Math.max(ans, Math.min(Math.abs(ninjas[l]-house) ,Math.abs(ninjas[r]-house) ) );
        }
        return ans;
    }
}