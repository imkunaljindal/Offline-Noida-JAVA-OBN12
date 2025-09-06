public class Kadanes {

    public static void main(String[] args) {
        int arr[] = {3,4,-10,2};

        int n = arr.length;

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int sum = 0;
            for(int j=i;j<n;j++) {
                sum += arr[j];
                ans = Math.max(ans,sum);
            }
        }

        System.out.println(ans);
    }
}
