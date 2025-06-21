public class Camel extends Animal {
    int humps;

    Camel() {
        super(4);
        System.out.println("Camel constructor is called");
    }
    void storeWater() {
        System.out.println(super.eyes);
        System.out.println(this.legs);
        System.out.println("I can store water in my humps");
    }
}
