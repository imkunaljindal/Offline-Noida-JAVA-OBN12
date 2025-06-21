package abstraction;

public class Sbi implements Bank{
    @Override
    public double getRateOfInterest() {
        return 6.7;
    }

    @Override
    public void printName(String name) {
        System.out.println("Hello Mr. "+name+" from SBI");
    }
}
