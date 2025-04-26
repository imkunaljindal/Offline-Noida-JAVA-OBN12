public class Concept {

    public static void main(String[] args) {

        int n=3;

        // O(n)
        for(int i=0;i<n;i++) {
            System.out.println("Hello");
        }

        // O(1) -> constant time
        for(int i=0;i<10;i++) {
            System.out.println("Hello");
        }

        // O(n^2)
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.println("Hello");
            }
        }

        // o(sqrt(n))
        for(int i=1;i<=Math.sqrt(n);i++) {
            System.out.println("Hello");
        }

        // O(logn)
        for(int i=1;i<=n;i=i*2) {
            System.out.println("Hello");
        }

        // O(logn)
        for(int i=n;i>=1;i=i/2) {
            System.out.println("Hello");
        }

        // O(nlogn)
        for(int i=1;i<n;i=i*2) {
            for(int j=0;j<n;j=j++) {
                System.out.println("Hello");
            }
        }

        //O(n^2)
        for(int i=0;i<n;i++) {
            for(int j=n;j>=1;j--) {
                System.out.println("Hello");
            }
        }

        // O(n)
        for(int i=0;i<n;i++) {
            System.out.println("Hello");
        }

        // O(n)
        for(int i=1;i<n;i++) {
            System.out.println("Hello");
        }

        // O(n*5) = O(n)
        for(int i=0;i<n;i++) {
            for(int j=0;j<5;j++) {
                System.out.println("Hello");
            }
        }

        // O(infinite)
        for(int i=0;i<n;i=i*2) {
            System.out.println("Hello");
        }
    }

    . void printArray(int arr[], int n) {

    }
}
