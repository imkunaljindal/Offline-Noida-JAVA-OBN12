class Person {
    String name;
    int age;
    String email;

    // default constructor
  //  Person() {}

    // parametrized constructor
    Person(String name){
        this.name = name;
    }

    Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    Person(String name, int age, String email) {
        this(name,email);
       // this.name = name;
        this.age = age;
    }

    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
        this.email = p.email;
    }

    void printAddress() {
        System.out.println(this);
    }

    void sayHello() {
        System.out.println("Hello my name is "+ name);
    }
}

public class Main {

    public static void main(String[] args) {
        Person p8 = new Person("abc",25,"abc@gmail.com");
        Person p9 = new Person(p8);
        Person p10 = new Person(p9);
        System.out.println(p9.name);
        //Person p1 = new Person();
        //System.out.println(p1);
//
//        Person p2 = new Person();
//
//        p1.name = "Kohli";
//        p1.age = 35;
//
//        System.out.println(p1.name);
//        System.out.println(p1.age);
//
//        System.out.println(p2.name);
//        System.out.println(p2.age);
//
//        p1.sayHello();

//        Person p3 = new Person("John");
//        System.out.println(p3.name);
//        System.out.println(p3.age);
//
//        Person p4 = new Person("Mike",30);
//        System.out.println(p4.name);
//        System.out.println(p4.age);

//        Person p5 = new Person();
//        //System.out.println(p5);
//        p5.printAddress();
//
//        Person p6 = new Person();
//        p6.printAddress();

        //Person p5 = new Person();

        Integer a = new Integer(10);
        int b = 20;
        System.out.println(a);

        //Auto-Boxing]
        Integer x = new Integer(100);
        int y = x; //Auto-unboxing

        System.out.println(x.intValue());
        System.out.println(y);
    }
}
