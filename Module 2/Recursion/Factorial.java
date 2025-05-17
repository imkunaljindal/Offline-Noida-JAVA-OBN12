public class Factorial {

    static int fact(int n) {
        if(n==1) return 1;
        int x = fact(n-1);
        return n*x;
    }

    public static void main(String[] args) {
        int x = 25;
        System.out.println(fact(x));
    }
}
