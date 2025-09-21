import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class Solution
{
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        double items[][] = new double[n][3];
        for(int i=0;i<arr.length;i++) {
            items[i][0] = arr[i].weight;
            items[i][1] = arr[i].value;
            items[i][2] = ((arr[i].value*1.0)/(arr[i].weight));
        }

        Arrays.sort(items,(a,b) -> Double.compare(b[2],a[2]));

        double totalValue = 0;
        for(int i=0;i<n;i++) {
            if(W >= items[i][0]) {
                totalValue += items[i][1];
                W -= items[i][0];
            }
            else {
                // break
                totalValue += (W/items[i][0])*items[i][1];
                break;
            }
        }
        return totalValue;






    }
}