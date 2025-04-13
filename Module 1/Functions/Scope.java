public class Scope {

    static int fun(int n) {
        n = n+5;
        System.out.println(n);
        return n;
        System.out.println(n);  // unreachable statement
    }

    public static void main(String[] args) {
        int n = 5;
        fun(n);
        System.out.println(n);
    }
}
