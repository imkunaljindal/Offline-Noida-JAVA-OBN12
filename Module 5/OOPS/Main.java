import abstraction.Hdfc;
import abstraction.Idfc;
import abstraction.Sbi;
import encapsulation.Animal;
import inheritance.Student;
import inheritance.Tiger;
import polymorphism.AdvancedCalculator;
import polymorphism.Calculator;
import staticConcept.Employee;

public class Main {

    public static void main(String[] args) {
//       Customer c = new Customer();  //
//        System.out.println(c.name);
//        c.name = "Virat";
//        System.out.println(c.name);
//        c.sayHello();

//        Customer c2 = new Customer("Rohit",32,"hitman@gmail.com");
//        c2.sayHello();
//
//        Customer c3 = new Customer("Kohli",32,"hitman@gmail.com");

//        Student s = new Student("kohli");

//        Animal a = new Animal();
//        a.setName("Elephant");
//        System.out.println(a.getName());

//        Tiger t = new Tiger();
//        Animal a = new Animal();

//        Calculator c = new Calculator();
//        System.out.println(c.add(5,4));

//        Calculator a = new AdvancedCalculator();
//        System.out.println(a.add(4,5));
//
//        Sbi sbi = new Sbi();
//        Hdfc hdfc = new Hdfc();
//
//        System.out.println(sbi.getRateOfInterest());
//        System.out.println(hdfc.getRateOfInterest());

//        Idfc idfc = new Idfc();
//        idfc.hello();
//
//        System.out.println(idfc.getEmployees());

        Employee e1 = new Employee();
        e1.name = "ABC";
        e1.age = 28;

        System.out.println(Employee.numberOfEmployees);

        Employee e2 = new Employee();
        e2.name = "XYZ";
        e2.age = 29;

        System.out.println(Employee.numberOfEmployees);

    }
}
