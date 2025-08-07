import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n];
        int d[] = new int[n];
        int j=0;
        int k=0;

        for(int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(new Solution().tour(p,d));
    }
}
class Solution
{
    int tour(int petrol[], int distance[])
    {
        int n = petrol.length;

        int totalPetrol = 0;
        int totalDistance = 0;

        for(int i=0;i<n;i++) {
            totalDistance += distance[i];
            totalPetrol += petrol[i];
        }

        if(totalPetrol < totalDistance) {
            return -1;
        }

        int start = 0;
        int currPetrol = 0;
        for(int i=0;i<n;i++) {
            currPetrol += petrol[i];
            currPetrol -= distance[i];

            if(currPetrol<=0) {
                currPetrol = 0;
                start = i+1;
            }
        }

//        for(int i=0;i<n;i++) {
//            int idx = (i+start)%n;
//            currPetrol += petrol[i];
//            currPetrol -= distance[i];
//
//            if(currPetrol<=0) {
//                currPetrol = 0;
//                start = i+1;
//            }
//        }

        return start;
    }
}