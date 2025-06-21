package polymorphism;

public class Concept {

    public static void main(String[] args) {
//        Calculator c = new Calculator();
//        System.out.println(c.add(4,5));
//
//        Calculator c1 = new Calculator();
//        Calculator c2 = new Calculator(5);

        Vehicle v = new Car();
        v.move();
        System.out.println(v.wheels);
    }
}
