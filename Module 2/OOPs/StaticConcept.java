class Customer {
    String name;
    int age;
    String gender;
    static String nationality = "ind";

    Customer(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    void hello() {
        System.out.println("Hi! My name is "+this.name+ " and my nation is "+nationality);
        getCompanyName();
    }

    static String getCompanyName() {
        return "Acciojob";
    }
}

class Car {
    String name;
    static int totalCars;

    Car(String name) {
        this.name = name;
        totalCars++;
    }
}

public class StaticConcept {
    public static void main(String[] args) {
//        Customer c1 = new Customer("Kohli",36,"male");
//        Customer c2 = new Customer("Rohit",37,"male");
//
//        System.out.println(c1.age);
//        System.out.println(c2.age);
//
//        System.out.println(Customer.nationality);

//        System.out.println(Car.totalCars);
//        Car c = new Car("Maruti");
//        System.out.println(Car.totalCars);
//        Car c2 = new Car("abc");
//        System.out.println(Car.totalCars);

        System.out.println(Customer.getCompanyName());
    }
}
