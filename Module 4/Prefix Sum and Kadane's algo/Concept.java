public class Concept {

    public static void main(String[] args) {
        int arr[] = {4,2,1,6,2,8};

        int prefix[] = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            if(i==0) prefix[i] = arr[i];
            else prefix[i] = prefix[i-1] + arr[i];
        }

        int suffix[] = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--) {
            if(i==arr.length-1) suffix[i] =  arr[i];
            else suffix[i] = suffix[i+1] + arr[i];
        }

        for(int i=0;i<prefix.length;i++) {
            System.out.print(prefix[i] + " ");
        }

        System.out.println();

        for(int i=0;i<suffix.length;i++) {
            System.out.print(suffix[i] + " ");
        }
    }
}
