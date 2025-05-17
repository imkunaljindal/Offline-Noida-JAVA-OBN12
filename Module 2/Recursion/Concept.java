public class Concept {

    static void fun1() {
        System.out.println("C");
        fun2();
    }
    static void fun2() {
        System.out.println("D");
    }
    public static void main(String[] args) {

        System.out.println("A");
        fun1();
        System.out.println("B");
    }
}
