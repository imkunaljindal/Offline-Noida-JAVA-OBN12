package Problems;

import java.util.*;

public class FirstAndLastIndex {

    static int firstPosition(int a[], int n, int k) {
        int s = 0;
        int e = n-1;

        int first = -1;
        while(s<=e) {
            int mid = (s+e)/2;
            if(a[mid]==k) {
                first = mid;
                e = mid-1;
            }
            else if(a[mid]>k) {
                e = mid-1;
            }
            else s = mid+1;
        }
        return first;
    }

    static int lastPosition(int a[], int n, int k) {
        int s = 0;
        int e = n-1;

        int last = -1;
        while(s<=e) {
            int mid = (s+e)/2;
            if(a[mid]==k) {
                last = mid;
                s = mid+1;
            }
            else if(a[mid]>k) {
                e = mid-1;
            }
            else s = mid+1;
        }
        return last;
    }

    public static void findPosition(int a[], int n,int k)
    {
        int firstPos = firstPosition(a,n,k);
        int lastPos = lastPosition(a,n,k);
        System.out.println(firstPos + " " + lastPos);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        findPosition(array,n,k);
    }
}