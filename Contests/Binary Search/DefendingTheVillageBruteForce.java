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
        // Sort the houses array.
        Arrays.sort(houses);
        Arrays.sort(ninjas);
        int result=0;

        int distance=0;

        for(int i=0; i < n; i++){

            int j=0;
            while(j <= m-1 && ninjas[j] < houses[i]){
                j++;
            }

            // If i is smaller than all elements of the ninjas array.
            if(j == 0){
                distance = ninjas[0] - houses[i];
            }

            // If i is larger than all elements of the ninjas array.
            else if(j == m){
                distance = houses[i] - ninjas[m-1];
            }

            // If the size of i is between two adjacent elements of the heater array.
            else{
                distance = Math.min(ninjas[j]-houses[i], houses[i]-ninjas[j-1]);
            }

            if(result < distance){
                result = distance;
            }
        }

        return result;
    }
}