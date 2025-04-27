package PortalQuestions;

public class OptimusPrime {

    static boolean checkPrime(int n) {

//        for(int i=2;i<=n-1;i++) {
//            if(n%i==0) {
//                return false;
//            }
//        }

        // O(sqrt(n))
        for(int i=2;i*i<=n;i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 10;

        for(int i=1;i<=n;i++) {
            if(checkPrime(i) == true) {
                System.out.println(i);
            }
        }
    }
}
