public class Scope {

    static void fun(int n) {
        n = n+5;
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 5;
        fun(n);
        System.out.println(n);
    }
}
