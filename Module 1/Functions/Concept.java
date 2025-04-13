public class Concept {

    static int factorial(int n) {
        int ans = 1;
        for(int i=1;i<=n;i++) {
            ans = ans*i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int r = 3;

        // n factorial
        int n_fact = factorial(n);

        int r_fact = factorial(r);

        int n_r_fact = factorial(n-r);

        int ans = (n_fact)/(r_fact*n_r_fact);
        System.out.println(ans);
    }
}
