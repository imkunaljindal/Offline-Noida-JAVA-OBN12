import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String inputLine[] = br.readLine().trim().split(" ");

        int n = Integer.parseInt(inputLine[0]);
        Job[] arr = new Job[n];
        inputLine = br.readLine().trim().split(" ");

        //adding id, deadline, profit
        for(int i=0, k=0; i<n; i++){
            arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
        }

        Solution ob = new Solution();

        //function call
        int[] res = ob.solve(arr, n);
        System.out.println (res[0] + " " + res[1]);

    }
}

class Solution
{

    int[] solve(Job arr[], int n)
    {
        int maxDeadline = -1;
        for(int i=0;i<n;i++) {
            maxDeadline = Math.max(maxDeadline,arr[i].deadline);
        }

        Arrays.sort(arr,(a,b) -> b.profit-a.profit); // dec order of profit

        boolean slots[] = new boolean[maxDeadline+1];
        int jobCount = 0;
        int maxProfit = 0;

        for(int i=0;i<n;i++) {
            for(int j=arr[i].deadline; j>=1;j--) {
                if(slots[j]==false) {
                    slots[j] = true;
                    jobCount++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }

        int ans[] = new int[]{jobCount,maxProfit};
        return ans;
    }
}
