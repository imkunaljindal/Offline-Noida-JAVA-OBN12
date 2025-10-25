package inheritance;

public class Person {

    public Person() {
        System.out.println("This is Person class");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("Paratemrized person constructor called");
    }

    public String name;
    public int age;

    public void sayHello() {
        System.out.println("This is Person class");
    }
}
