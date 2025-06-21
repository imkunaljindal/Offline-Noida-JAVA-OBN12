public class Animal {

    int legs;
    int eyes;

    Animal() {
        System.out.println("Animal constructor is called");
    }

    Animal(int legs) {
        System.out.println("Parametrized Animal constructor is called");
        this.legs = legs;
    }

    void walk() {
        System.out.println("I am walking");
    }
}
