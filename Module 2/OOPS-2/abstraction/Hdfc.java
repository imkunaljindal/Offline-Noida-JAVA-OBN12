package abstraction;

public class Hdfc implements Bank{

    @Override
    public double getRateOfInterest() {
        return 7.1;
    }

    @Override
    public void printName(String name) {
        System.out.println("Hello Mr. "+name+" from HDFc");
    }
}
