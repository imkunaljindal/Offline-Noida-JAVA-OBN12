import java.util.*;

class Solution{
    public int findPeak(int arr[], int n)
    {
        if(arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-2]) return n-1;

        int s = 1;
        int e = n-2;

        while(s<=e) {
            int mid = s +(e-s)/2;
            if((arr[mid]>arr[mid-1]) && (arr[mid]>arr[mid+1])) return mid;
            if(arr[mid]>arr[mid-1]) s = mid+1;
            else e = mid-1;
        }

        return -1;

    }
}

class PeakElement{
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int t=sc.nextInt();
            while(t>0){
                int n=sc.nextInt();
                int []A=new int[n];
                for(int i=0;i<n;i++){
                    A[i]=sc.nextInt();
                }
                Solution ob =new Solution();
                int ans = ob.findPeak(A,n);
                if(ans==0){
                    if(A[ans]>A[ans+1]){
                        System.out.println("true");
                    }
                    else{
                        System.out.println("false");
                    }
                }
                else if(ans==n-1){
                    if(A[ans]>A[ans-1]){
                        System.out.println("true");
                    }
                    else{
                        System.out.println("false");
                    }
                }
                else{
                    if(A[ans]>A[ans+1] && A[ans]>A[ans-1]){
                        System.out.println("true");
                    }
                    else{
                        System.out.println("false");
                    }
                }
                t--;
            }
        }
    }
}