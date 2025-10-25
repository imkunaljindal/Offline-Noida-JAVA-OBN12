package staticConcept;

public class Employee {

    public Employee() {
        numberOfEmployees++;
    }

    public String name;
    public int age;
    public static int numberOfEmployees;
    public final String company = "Google";
}
