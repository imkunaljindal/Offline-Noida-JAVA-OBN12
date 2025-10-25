package abstraction;

public class Sbi implements Bank {
    public int getRateOfInterest() {
        return 4;
    }

    @Override
    public String getDetails() {
        return "This is SBI bank";
    }
}
