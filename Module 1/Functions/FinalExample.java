public class FinalExample {
    static void f1() {
        String ans = f2();
        System.out.println("C");
    }

    static String f2() {
        return "D";
    }

    public static void main(String[] args) {
        System.out.println("A");
        f1();
        System.out.println("B");
    }
}
