public class Customer {

    // default constructor
//    Customer() {
//        System.out.println("Customer object is created");
//    }

    Customer(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    String name;
    int age;
    String email;

    void sayHello() {
        System.out.println("Hello! My name is "+name);
    }
}
